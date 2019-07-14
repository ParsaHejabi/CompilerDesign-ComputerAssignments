package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;

import java.util.ArrayList;

public class VarDclCnts implements CodeGeneratable {
    public ArrayList<VarDclCnt> varDclCnts;

    public VarDclCnts() {
        varDclCnts = new ArrayList<>();
    }

    public void addElement(VarDclCnt vdc) {
        varDclCnts.add(vdc);
    }

    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public void visit() {

    }
}
