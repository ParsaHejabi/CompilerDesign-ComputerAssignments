package ASTNodes;

import ASTNodes.Enums.ArithmaticType;
import ASTNodes.Enums.ConditionType;
import ASTNodes.Enums.UnaryOperators;
import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class Expr implements CodeGeneratable {
    public UnaryOperators opType;
    public Expr expr1, expr2;
    public ArithmaticType arithmaticType;
    public ConditionType condiTionType;

    public Expr() {
    }

    public Expr(Expr expr1, Expr expr2, ConditionType condiionType) {
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

    @Override
    public String generateCode() {
        return "";
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        return "";
    }
}
