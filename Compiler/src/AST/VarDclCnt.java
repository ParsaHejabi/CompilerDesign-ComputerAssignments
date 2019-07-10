package AST;

public class VarDclCnt extends AbstractNode {
    public Expr expr;

    public VarDclCnt(Expr expr) {
        this.expr = expr;
    }

    public VarDclCnt() {
        expr = null;
    }

    @Override
    public String CG() {
        return "var_dcl_cnt";
    }

    @Override
    public void CreateSymbolTable() {
        super.CreateSymbolTable();
    }
}
