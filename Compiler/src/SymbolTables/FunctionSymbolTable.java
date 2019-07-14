package SymbolTables;

import ASTNodes.FuncDcl;

import java.util.Hashtable;

public class FunctionSymbolTable implements SymbolTable {
    public FuncDcl funcDcl;
    public Hashtable<String, VariableSymbolTable> functionVariables;
    public Hashtable<String, BlockSymbolTable> functionBlocks;

    public FunctionSymbolTable(FuncDcl funcDcl) {
        this.funcDcl = funcDcl;
        functionVariables = new Hashtable<>();
        functionBlocks = new Hashtable<>();
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
}
