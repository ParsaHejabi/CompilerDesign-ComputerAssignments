package SymbolTables;

import ASTNodes.Type;

import java.util.ArrayList;

public interface SymbolTable {
    SymbolTable getBlock(String name);

    SymbolTable exitScope();

    SymbolTableVariable lookupSymbolTableVariable(String name);

    boolean lookupFunction(String name, ArrayList paramNames, String[] paramTypes, String returnType);

    FunctionSymbolTable getCurrentFunctionSymbolTable();

    void addSymbolTableVariable(String name, Type type);
}
