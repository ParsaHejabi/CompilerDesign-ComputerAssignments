package SymbolTables;

import ASTNodes.FuncDcl;
import ASTNodes.Type;

import java.util.Hashtable;

public class StructSymbolTable implements SymbolTable {
    public String name;
    public Hashtable<String, SymbolTableVariable> structVariables;

    public StructSymbolTable(String name) {
        this.name = name;
        structVariables = new Hashtable<>();
    }

    public SymbolTableVariable getVariableSymbolTable(String variableName) {
        return structVariables.get(variableName);
    }

    public void addVariableSymbolTable(String name, SymbolTableVariable symbolTableVariable) {
        structVariables.put(name, symbolTableVariable);
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
    public SymbolTableVariable lookupSymbolTableVariable(String name) {
        if (structVariables.get(name) != null) {
            return structVariables.get(name);
        } else {
            System.err.println(this.getClass() + "variable " + name + " not found.");
            return null;
        }
    }

    @Override
    public FunctionSymbolTable lookupFunction(FuncDcl funcDcl) {
        return null;
    }

    @Override
    public FunctionSymbolTable getCurrentFunctionSymbolTable() {
        return null;
    }

    @Override
    public void addSymbolTableVariable(String name, Type type) {
        structVariables.put(name, new SymbolTableVariable(name, type, false));
    }

    @Override
    public void addBlock(String name, SymbolTable parentSymbolTable) {
    }
}
