package SymbolTables;

import java.util.ArrayList;
import java.util.Hashtable;

public class StructSymbolTable implements SymbolTable {
    public String name;
    public Hashtable<String, VariableSymbolTable> structVariables;

    public StructSymbolTable(String name) {
        this.name = name;
        structVariables = new Hashtable<>();
    }

    public VariableSymbolTable getVariableSymbolTable(String variableName) {
        return structVariables.get(variableName);
    }

    public void addVariableSymbolTable(String name, VariableSymbolTable variableSymbolTable) {
        structVariables.put(name, variableSymbolTable);
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
        addVariableSymbolTable(name, (VariableSymbolTable) variable);
    }
}
