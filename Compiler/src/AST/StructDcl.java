package AST;

import java.util.ArrayList;

public class StructDcl extends AbstractNode {
    public ArrayList<VarDcl> varDclArrayList;

    public StructDcl() {
        this.varDclArrayList = new ArrayList<>();
    }

    public void addElement(VarDcl varDcl) {
        varDclArrayList.add(varDcl);
    }

    public VarDcl get(int i) {
        return varDclArrayList.get(i);
    }

    public int size() {
        return varDclArrayList.size();
    }

    @Override
    public String CG() {
        return "struct_dcl";
    }

    @Override
    public void CreateSymbolTable() {
        super.CreateSymbolTable();
    }
}
