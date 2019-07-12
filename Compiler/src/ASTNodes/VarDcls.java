package ASTNodes;

import java.util.ArrayList;

public class VarDcls {
    public ArrayList<VarDcl> varDclList;

    public VarDcls() {
        varDclList = new ArrayList<>();
    }

    public void addElement(VarDcl vd){
        varDclList.add(vd);
    }
}
