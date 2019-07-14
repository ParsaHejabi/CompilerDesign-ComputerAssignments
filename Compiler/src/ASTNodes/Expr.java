package ASTNodes;

import ASTNodes.Enums.ArithmaticType;
import ASTNodes.Enums.CondiTionType;
import ASTNodes.Enums.UnaryOperators;

public class Expr {
    public UnaryOperators opType;
    public Expr expr1, expr2;
    public ArithmaticType arithmaticType;
    public CondiTionType condiTionType;

    public Expr(Expr expr1, Expr expr2, CondiTionType condiionType) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.condiTionType = condiionType;
    }

    public Expr(Expr expr1, Expr expr2, ArithmaticType arithmaticType) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.arithmaticType = arithmaticType;
    }

    public void setOpType(UnaryOperators opType) {
        this.opType = opType;
    }
}
