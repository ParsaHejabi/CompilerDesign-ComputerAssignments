package SymbolTables;

import ASTNodes.FuncDcl;
import ASTNodes.Type;

public interface SymbolTable {
    SymbolTable getBlock(String name);

    SymbolTable exitScope();

    SymbolTableVariable lookupSymbolTableVariable(String name);

    FunctionSymbolTable lookupFunction(FuncDcl funcDcl);

    FunctionSymbolTable getCurrentFunctionSymbolTable();

    void addSymbolTableVariable(String name, Type type);
}
