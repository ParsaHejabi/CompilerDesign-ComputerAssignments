package ASTNodes;

import java.util.ArrayList;

public class VarDclCnts {
    public ArrayList<VarDclCnt> varDclCnts;

    public VarDclCnts() {
        varDclCnts = new ArrayList<>();
    }

    public void addElement(VarDclCnt vdc) {
        varDclCnts.add(vdc);
    }
}
