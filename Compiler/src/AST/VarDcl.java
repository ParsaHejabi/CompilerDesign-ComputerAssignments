package AST;

import java.util.ArrayList;

public class VarDcl extends AbstractNode {
    public Type type;
    public ArrayList<VarDclCnt> varDclCntArrayList;
    public boolean isConstant;

    public VarDcl(Type type, boolean isConstant) {
        this.type = type;
        this.isConstant = isConstant;
        this.varDclCntArrayList = new ArrayList<>();
    }

    @Override
    public String CG() {
        return "var_dcl";
    }

    @Override
    public void CreateSymbolTable() {
        super.CreateSymbolTable();
    }
}
