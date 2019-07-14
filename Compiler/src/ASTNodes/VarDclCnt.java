package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import ASTNodes.Interfaces.SymbolTableCreatable;

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
    public void visit() {

    }

    @Override
    public void createSymbolTable() {

    }
}
