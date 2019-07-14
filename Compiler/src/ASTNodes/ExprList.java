package ASTNodes;

import java.util.ArrayList;

public class ExprList {
    public ArrayList<Expr> exprs;

    public ExprList() {
        this.exprs = new ArrayList<>();
    }

    public void addElement(Expr e) {
        exprs.add(e);
    }
}
