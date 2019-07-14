package SymbolTables;

import java.util.Hashtable;

public class ProgramSymbolTable implements SymbolTable {
    public Hashtable<String, VariableSymbolTable> variableSymbolTableHashtable;
    public Hashtable<String, FunctionSymbolTable> functionSymbolTableHashtable;
    public Hashtable<String, StructSymbolTable> structSymbolTableHashtable;

    public ProgramSymbolTable() {
        variableSymbolTableHashtable = new Hashtable<>();
        functionSymbolTableHashtable = new Hashtable<>();
        structSymbolTableHashtable = new Hashtable<>();
    }

    public VariableSymbolTable getVariableSymbolTable(String variableName) {
        return variableSymbolTableHashtable.get(variableName);
    }

    public void addVariableSymbolTable(String name, VariableSymbolTable variableSymbolTable) {
        variableSymbolTableHashtable.put(name, variableSymbolTable);
    }

    public FunctionSymbolTable getFunctionSymbolTable(String functionName) {
        return functionSymbolTableHashtable.get(functionName);
    }

    public void addFunctionSymbolTable(String name, FunctionSymbolTable functionSymbolTable) {
        functionSymbolTableHashtable.put(name, functionSymbolTable);
    }

    public StructSymbolTable getStructSymbolTable(String structName) {
        return structSymbolTableHashtable.get(structName);
    }

    public void addStructSymbolTable(String name, StructSymbolTable structSymbolTable) {
        structSymbolTableHashtable.put(name, structSymbolTable);
    }
}
