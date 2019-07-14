package SymbolTables;

import ASTNodes.FuncDcl;
import ASTNodes.Type;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class FunctionSymbolTable implements SymbolTable {
    public FuncDcl funcDcl;
    public Hashtable<String, SymbolTableVariable> functionVariables;
    public Hashtable<String, BlockSymbolTable> functionBlocks;
    public int num;

    public FunctionSymbolTable(FuncDcl funcDcl, int num) {
        this.funcDcl = funcDcl;
        functionVariables = new Hashtable<>();
        functionBlocks = new Hashtable<>();
        this.num = num;
    }

    public SymbolTableVariable getVariableSymbolTable(String variableName) {
        return functionVariables.get(variableName);
    }

    public void addVariableSymbolTable(String name, SymbolTableVariable symbolTableVariable) {
        functionVariables.put(name, symbolTableVariable);
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
    public SymbolTableVariable lookupSymbolTableVariable(String name) {
        if (functionVariables.get(name) != null) {
            return functionVariables.get(name);
        } else {
            Set<String> keySet = functionBlocks.keySet();

            for (String key : keySet) {
                if (functionBlocks.get(key).blockVariables.get(name) != null) {
                    return functionBlocks.get(key).blockVariables.get(name);
                }
            }
        }
        System.err.println(this.getClass() + "variable " + name + " not found.");
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
    public void addSymbolTableVariable(String name, Type type) {
    }
}
