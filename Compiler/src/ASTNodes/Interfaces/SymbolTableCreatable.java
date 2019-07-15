package ASTNodes.Interfaces;

import SymbolTables.SymbolTable;

import java.util.Vector;

public interface SymbolTableCreatable {
    void createSymbolTable(Vector<SymbolTable> symbolTableVector);
}
