package ASTNodes;

import ASTNodes.Enums.AssignmentType;

public class Assignment {
    public Expr expr;
    public Variable var;
    public AssignmentType assignmentType;

    public Assignment(Expr expr, Variable var, AssignmentType assignmentType) {
        this.expr = expr;
        this.var = var;
        this.assignmentType = assignmentType;
    }

    public Assignment(Expr expr, Variable var) {
        this.expr = expr;
        this.var = var;
    }

    public Assignment() {
    }
}
