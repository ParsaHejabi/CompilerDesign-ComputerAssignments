package ASTNodes.Interfaces;

import SymbolTables.SymbolTable;

import java.util.Vector;

public interface CodeGeneratable {
    String generateCode();

    String visit(Vector<SymbolTable> symbolTableVector);
}
