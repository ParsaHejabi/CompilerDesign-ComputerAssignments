package SymbolTables;

public interface SymbolTable {
    void addBlock(String name);

    SymbolTable exitBlock();
}
