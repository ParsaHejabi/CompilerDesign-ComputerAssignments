package ASTNodes;

import ASTNodes.Enums.UnaryOperators;

public class UnaryExecution extends Variable {
    public Variable var;
    public UnaryOperators type;

    public UnaryExecution(Variable var, UnaryOperators type) {
        this.var = var;
        this.type = type;
    }
}
