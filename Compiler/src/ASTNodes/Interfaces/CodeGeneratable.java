package ASTNodes.Interfaces;

import SymbolTables.SymbolTable;

public interface CodeGeneratable {
    String generateCode();

    void visit(SymbolTable symbolTable);
}
