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

    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        return null;
    }
}
