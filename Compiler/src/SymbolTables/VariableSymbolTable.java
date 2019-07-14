package SymbolTables;

import ASTNodes.Enums.TypeEnum;
import ASTNodes.ExprList;

import java.util.ArrayList;

public class VariableSymbolTable implements SymbolTable {
    public String name;
    public TypeEnum type;
    public boolean isGlobal;
    public ExprList exprList;

    public VariableSymbolTable(String name, TypeEnum type, boolean isGlobal) {
        this.name = name;
        this.type = type;
        this.isGlobal = isGlobal;
        exprList = new ExprList();
    }

    @Override
    public SymbolTable getBlock(String name) {
        return null;
    }

    @Override
    public SymbolTable exitScope() {
        return null;
    }

    @Override
    public VariableSymbolTable lookupVariableSymbolTable(String name) {
        return null;
    }

    @Override
    public VariableSymbolTable localLookupVariableSymbolTable(String name) {
        return null;
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
    public void addVariableToSymbolTable(String name, Object variable) {

    }
}
