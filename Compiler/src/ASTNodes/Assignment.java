package ASTNodes;

import ASTNodes.Enums.AssignmentType;

import java.beans.Expression;

public class Assignment {
    public Expression expr;
    public Variable var;
    public AssignmentType assignmentType;

    public Assignment(Expression expr, Variable var, AssignmentType assignmentType) {
        this.expr = expr;
        this.var = var;
        this.assignmentType = assignmentType;
    }

    public Assignment(Expression expr, Variable var) {
        this.expr = expr;
        this.var = var;
    }

    public Assignment() {
    }
}
