package ASTNodes;

import java.beans.Expression;

public class For {
    public Assignment assignment;
    public Expression expression;
    public Block block;
    public AssignmentOrExpression assignmentOrExpression;

    public For(Expression expression, Block block, AssignmentOrExpression assignmentOrExpression) {
        this.expression = expression;
        this.block = block;
        this.assignmentOrExpression = assignmentOrExpression;
    }

    public For(Assignment assignment, Expression expression, Block block, AssignmentOrExpression assignmentOrExpression) {
        this.assignment = assignment;
        this.expression = expression;
        this.block = block;
        this.assignmentOrExpression = assignmentOrExpression;
    }
}
