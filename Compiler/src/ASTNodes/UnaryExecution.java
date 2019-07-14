package ASTNodes;

import ASTNodes.Enums.UnaryOperators;

public class UnaryExecution {
    public Variable var;
    public UnaryOperators type;

    public UnaryExecution(Variable var, UnaryOperators type) {
        this.var = var;
        this.type = type;
    }
}
