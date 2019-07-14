package SymbolTables;

import ASTNodes.ExprList;
import ASTNodes.Type;

public class SymbolTableVariable {
    public String name;
    public Type type;
    public boolean isGlobal;
    public ExprList exprList;

    public SymbolTableVariable(String name, Type type, boolean isGlobal) {
        this.name = name;
        this.type = type;
        this.isGlobal = isGlobal;
        exprList = new ExprList();
    }
}
