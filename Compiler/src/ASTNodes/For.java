package ASTNodes;

public class For {
    public Assignment assignment;
    public Expr expr;
    public Block block;
    public AssignmentOrExpression assignmentOrExpression;

    public For(Expr expr, Block block, AssignmentOrExpression assignmentOrExpression) {
        this.expr = expr;
        this.block = block;
        this.assignmentOrExpression = assignmentOrExpression;
    }

    public For(Assignment assignment, Expr expr, Block block, AssignmentOrExpression assignmentOrExpression) {
        this.assignment = assignment;
        this.expr = expr;
        this.block = block;
        this.assignmentOrExpression = assignmentOrExpression;
    }
}
