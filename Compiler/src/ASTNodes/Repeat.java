package ASTNodes;

public class Repeat {
    public Block block;
    public Expr expr;

    public Repeat(Block block, Expr expr) {
        this.block = block;
        this.expr = expr;
    }
}
