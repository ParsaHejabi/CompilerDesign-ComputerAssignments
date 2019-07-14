package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;
import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTableVariable;

import java.util.Vector;

public class VarDclCnt implements CodeGeneratable, SymbolTableCreatable {
    public boolean isConstant;
    public String identifier;
    public Type type;
    public Expr expr;

    public VarDclCnt(String identifier, Expr expr) {
        this.identifier = identifier;
        this.expr = expr;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public void setConstant(boolean constant) {
        isConstant = constant;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        if (expr != null) {
        }
        //expr.visit();
        return null;

    }

    @Override
    public void createSymbolTable(SymbolTable symbolTable) {
        symbolTable.addSymbolTableVariable(identifier, type);

        SymbolTableVariable table = symbolTable.lookupSymbolTableVariable(identifier);

        if (expr != null) {
            table.exprList.exprs.add(expr);
        }
    }
}
