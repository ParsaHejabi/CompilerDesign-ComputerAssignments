package SymbolTables;

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
}
