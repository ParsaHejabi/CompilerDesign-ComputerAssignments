package ASTNodes;

import java.beans.Expression;
import java.util.ArrayList;

public class Parameters {
    public ArrayList<Expression> expressions;

    public Parameters() {
        this.expressions = new ArrayList<>();
    }

    public void addElement(Expression e) {
        this.expressions.add(e);
    }
}
