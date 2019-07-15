package ASTNodes;

import java.util.ArrayList;

public class VarDcls {
    public ArrayList<VarDcl> varDclList;

    public VarDcls() {
        varDclList = new ArrayList<>();
    }

    public int size() {
        return varDclList.size();
    }

    public VarDcl getElement(int index) {
        return varDclList.get(index);
    }

    public void addElement(VarDcl vd) {
        varDclList.add(vd);
    }
}
