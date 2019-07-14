package SymbolTables;

import ASTNodes.FuncDcl;

import java.util.ArrayList;
import java.util.Hashtable;

public class FunctionSymbolTable implements SymbolTable {
    public FuncDcl funcDcl;
    public Hashtable<String, VariableSymbolTable> functionVariables;
    public Hashtable<String, BlockSymbolTable> functionBlocks;
    public int num;

    public FunctionSymbolTable(FuncDcl funcDcl, int num) {
        this.funcDcl = funcDcl;
        functionVariables = new Hashtable<>();
        functionBlocks = new Hashtable<>();
        this.num = num;
    }

    public VariableSymbolTable getVariableSymbolTable(String variableName) {
        return functionVariables.get(variableName);
    }

    public void addVariableSymbolTable(String name, VariableSymbolTable variableSymbolTable) {
        functionVariables.put(name, variableSymbolTable);
    }

    public BlockSymbolTable getBlockSymbolTable(String blockName) {
        return functionBlocks.get(blockName);
    }

    public void addBlockSymbolTable(String name, BlockSymbolTable blockSymbolTable) {
        functionBlocks.put(name, blockSymbolTable);
    }

    @Override
    public SymbolTable getBlock(String name) {
        return functionBlocks.get(name);
    }

    @Override
    public SymbolTable exitScope() {
        return null;
    }

    @Override
    public VariableSymbolTable lookupVariableSymbolTable(String name) {
        return null;
    }

    @Override
    public VariableSymbolTable localLookupVariableSymbolTable(String name) {
        return null;
    }

    @Override
    public boolean lookupFunction(String name, ArrayList paramNames, String[] paramTypes, String returnType) {
        return false;
    }

    @Override
    public FunctionSymbolTable getCurrentFunctionSymbolTable() {
        return null;
    }

    @Override
    public void addVariableToSymbolTable(String name, Object variable) {
        if (variable instanceof VariableSymbolTable) {
            addVariableSymbolTable(name, (VariableSymbolTable) variable);
        } else if (variable instanceof BlockSymbolTable) {
            addBlockSymbolTable(name, (BlockSymbolTable) variable);
        }
    }
}
