package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;
import ASTNodes.Interfaces.SymbolTableCreatable;

import java.util.Vector;

public class VarDclCnt implements CodeGeneratable, SymbolTableCreatable {
    public String identifier;
    public Expr expr;

    public VarDclCnt(String identifier, Expr expr) {
        this.identifier = identifier;
        this.expr = expr;
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
    public void createSymbolTable() {

    }
}
