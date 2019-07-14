package ASTNodes;


public class If {
    public Expr expr;
    public Block ifBlock, elseBlock;

    public If(Expr expr, Block ifBlock, Block elseBlock) {
        this.expr = expr;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    public If(Expr expr, Block ifBlock) {
        this.expr = expr;
        this.ifBlock = ifBlock;
    }
}
