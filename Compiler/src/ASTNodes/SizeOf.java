package ASTNodes;

public class SizeOf extends Expr {
    public Type type;

    public SizeOf(Type type) {
        this.type = type;
    }
}
