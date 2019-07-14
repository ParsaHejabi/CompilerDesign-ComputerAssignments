package ASTNodes;

import java.beans.Expression;

public class AssignmentOrExpression {
    public Assignment assignment;
    public Expression expression;

    public AssignmentOrExpression(Expression expression) {
        this.expression = expression;
    }

    public AssignmentOrExpression(Assignment assignment) {
        this.assignment = assignment;
    }
}
