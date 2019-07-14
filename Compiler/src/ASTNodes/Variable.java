package ASTNodes;

public class Variable extends Expr {
    public String Identifier;
    public ExprList exprList;

    public Variable() {
    }

    public Variable(String identifier, ExprList exprList) {
        Identifier = identifier;
        this.exprList = exprList;
    }

    public Variable(String identifier) {
        Identifier = identifier;
    }
}
