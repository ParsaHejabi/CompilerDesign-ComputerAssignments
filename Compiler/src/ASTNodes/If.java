package ASTNodes;

import java.beans.Expression;

public class If {
    public Expression expr;
    public Block ifBlock, elseBlock;

    public If(Expression expr, Block ifBlock, Block elseBlock) {
        this.expr = expr;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }
}
