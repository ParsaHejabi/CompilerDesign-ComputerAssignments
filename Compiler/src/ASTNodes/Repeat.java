package ASTNodes;

import java.beans.Expression;

public class Repeat {
    public Block block;
    public Expression expression;

    public Repeat(Block block, Expression expression) {
        this.block = block;
        this.expression = expression;
    }
}
