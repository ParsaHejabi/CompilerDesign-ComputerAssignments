package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;
import ASTNodes.Interfaces.SymbolTableCreatable;

import java.util.Vector;

public class VarDcl implements CodeGeneratable, SymbolTableCreatable {
    public boolean isConstant;
    public Type type;
    public VarDclCnts varDclCnts;

    public VarDcl(boolean isConstant, Type type, VarDclCnts varDclCnts) {
        this.isConstant = isConstant;
        this.type = type;
        this.varDclCnts = varDclCnts;
    }

    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        this.generateCode();

        for (VarDclCnt dclCnt : varDclCnts.varDclCnts) {
            dclCnt.visit(symbolTableVector);
        }
        return "";
    }

    @Override
    public void createSymbolTable(SymbolTable symbolTable) {
        for (VarDclCnt dclCnt : varDclCnts.varDclCnts) {
            dclCnt.createSymbolTable(symbolTable);
        }
    }
}
