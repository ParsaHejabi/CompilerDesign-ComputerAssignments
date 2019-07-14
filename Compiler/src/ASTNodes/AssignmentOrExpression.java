package ASTNodes;

public class AssignmentOrExpression {
    public Assignment assignment;
    public Expr expr;

    public AssignmentOrExpression(Expr expr) {
        this.expr = expr;
    }

    public AssignmentOrExpression(Assignment assignment) {
        this.assignment = assignment;
    }
}
