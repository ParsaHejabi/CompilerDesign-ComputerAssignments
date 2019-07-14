package SymbolTables;

import ASTNodes.Enums.TypeEnum;

import java.util.Hashtable;

public class BlockSymbolTable implements SymbolTable {
    public SymbolTable parentSymbolTable;
    public Hashtable<String, VariableSymbolTable> blockVariables;
    public Hashtable<String, BlockSymbolTable> blockBlocks;

    public BlockSymbolTable(SymbolTable parentSymbolTable) {
        this.parentSymbolTable = parentSymbolTable;
        this.blockVariables = new Hashtable<>();
        this.blockBlocks = new Hashtable<>();
    }

    public VariableSymbolTable getVariableSymbolTable(String variableName) {
        return blockVariables.get(variableName);
    }

    public void addVariableSymbolTable(String name, TypeEnum type) {
        blockVariables.put(name, new VariableSymbolTable(name, type, false));
    }

    public BlockSymbolTable getBlockSymbolTable(String blockName) {
        return blockBlocks.get(blockName);
    }

    public void addBlockSymboltable(String name) {
        blockBlocks.put(name, new BlockSymbolTable(this));
    }
}
