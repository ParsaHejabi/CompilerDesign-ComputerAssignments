package ASTNodes;

import java.util.ArrayList;

public class Parameters {
    public ArrayList<Expr> exprs;

    public Parameters() {
        this.exprs = new ArrayList<>();
    }

    public void addElement(Expr e) {
        this.exprs.add(e);
    }
}
