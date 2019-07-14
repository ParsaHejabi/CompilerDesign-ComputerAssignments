package SymbolTables;

import java.util.ArrayList;

public interface SymbolTable {
    SymbolTable getBlock(String name);

    SymbolTable exitScope();

    VariableSymbolTable lookupVariableSymbolTable(String name);

    VariableSymbolTable localLookupVariableSymbolTable(String name);

    boolean lookupFunction(String name, ArrayList paramNames, String[] paramTypes, String returnType);

    FunctionSymbolTable getCurrentFunctionSymbolTable();

    void addVariableToSymbolTable(String name, Object variable);
}
