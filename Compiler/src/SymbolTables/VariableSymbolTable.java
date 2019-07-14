package SymbolTables;

import ASTNodes.Enums.TypeEnum;
import ASTNodes.ExprList;

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
}
