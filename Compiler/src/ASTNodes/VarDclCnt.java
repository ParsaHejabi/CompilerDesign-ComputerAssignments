package ASTNodes;

public class VarDclCnt {
    public String identifier;
    public Expr expr;

    public VarDclCnt(String identifier, Expr expr) {
        this.identifier = identifier;
        this.expr = expr;
    }
}
