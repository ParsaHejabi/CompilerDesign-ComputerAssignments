package AST;

public class Expr extends AbstractNode {
    @Override
    public String CG() {
        return "expr";
    }

    @Override
    public void CreateSymbolTable() {
        super.CreateSymbolTable();
    }
}
