package SymbolTables;

import ASTNodes.Type;

import java.util.ArrayList;
import java.util.Hashtable;

public class BlockSymbolTable implements SymbolTable {
    public SymbolTable parentSymbolTable;
    public Hashtable<String, SymbolTableVariable> blockVariables;
    public Hashtable<String, BlockSymbolTable> blockBlocks;

    public BlockSymbolTable(SymbolTable parentSymbolTable) {
        this.parentSymbolTable = parentSymbolTable;
        this.blockVariables = new Hashtable<>();
        this.blockBlocks = new Hashtable<>();
    }

    public SymbolTableVariable getVariableSymbolTable(String variableName) {
        return blockVariables.get(variableName);
    }

    public void addVariableSymbolTable(String name, Type type) {
        blockVariables.put(name, new SymbolTableVariable(name, type, false));
    }

    public BlockSymbolTable getBlockSymbolTable(String blockName) {
        return blockBlocks.get(blockName);
    }

    public void addBlockSymboltable(String name) {
        blockBlocks.put(name, new BlockSymbolTable(this));
    }

    @Override
    public SymbolTable getBlock(String name) {
        return blockBlocks.get(name);
    }

    @Override
    public SymbolTable exitScope() {
        return null;
    }

    @Override
    public SymbolTableVariable lookupSymbolTableVariable(String name) {
        if (blockVariables.get(name) != null) {
            return blockVariables.get(name);
        } else {
            return parentSymbolTable.lookupSymbolTableVariable(name);
        }
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
        blockVariables.put(name, new SymbolTableVariable(name, type, false));
    }
}
