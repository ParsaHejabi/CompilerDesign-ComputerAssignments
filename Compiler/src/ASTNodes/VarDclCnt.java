package ASTNodes;

public class VarDclCnt {
    public String identifier;
    public Expression expression;

    public VarDclCnt(String identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }
}
