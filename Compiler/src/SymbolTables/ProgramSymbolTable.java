package SymbolTables;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

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

    @Override
    public SymbolTable getBlock(String name) {
        Set<String> keySet = functionSymbolTableHashtable.keySet();
        for (String key : keySet) {
            if (key.equals(name)) {
                return functionSymbolTableHashtable.get(key);
            }
        }
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
        if (variable instanceof VariableSymbolTable) {
            addVariableSymbolTable(name, (VariableSymbolTable) variable);
        } else if (variable instanceof FunctionSymbolTable) {
            addFunctionSymbolTable(name, (FunctionSymbolTable) variable);
        } else if (variable instanceof StructSymbolTable) {
            addStructSymbolTable(name, (StructSymbolTable) variable);
        }
    }
}
