package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

import java.util.ArrayList;
import java.util.Vector;

public class VarDclCnts implements CodeGeneratable {
    public ArrayList<VarDclCnt> varDclCnts;

    public VarDclCnts() {
        varDclCnts = new ArrayList<>();
    }

    public void addElement(VarDclCnt vdc) {
        varDclCnts.add(vdc);
    }

    public void fixVarDclCntAttributes(Type type, boolean isConstant) {
        for (VarDclCnt dclCnt : varDclCnts) {
            dclCnt.setType(type);
            dclCnt.setConstant(isConstant);
        }
    }

    @Override
    public String generateCode() {
        return "";
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {

        return null;
    }
}
