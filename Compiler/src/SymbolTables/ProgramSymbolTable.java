package SymbolTables;

import ASTNodes.Type;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class ProgramSymbolTable implements SymbolTable {
    public Hashtable<String, SymbolTableVariable> variableSymbolTableHashtable;
    public Hashtable<String, FunctionSymbolTable> functionSymbolTableHashtable;
    public Hashtable<String, StructSymbolTable> structSymbolTableHashtable;

    public ProgramSymbolTable() {
        variableSymbolTableHashtable = new Hashtable<>();
        functionSymbolTableHashtable = new Hashtable<>();
        structSymbolTableHashtable = new Hashtable<>();
    }

    public SymbolTableVariable getVariableSymbolTable(String variableName) {
        return variableSymbolTableHashtable.get(variableName);
    }

    public void addVariableSymbolTable(String name, SymbolTableVariable symbolTableVariable) {
        variableSymbolTableHashtable.put(name, symbolTableVariable);
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
    public SymbolTableVariable lookupSymbolTableVariable(String name) {
        if (variableSymbolTableHashtable.get(name) != null) {
            return variableSymbolTableHashtable.get(name);
        } else {
            System.err.println(this.getClass() + "variable " + name + " not found.");
            return null;
        }
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
    public void addSymbolTableVariable(String name, Type type) {
        variableSymbolTableHashtable.put(name, new SymbolTableVariable(name, type, true));
    }
}
