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
        return "";
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        String instructions = "";
        instructions += this.generateCode();

        for (VarDclCnt dclCnt : varDclCnts.varDclCnts) {
            instructions += dclCnt.visit(symbolTableVector);
        }
        return instructions;
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {
        varDclCnts.fixVarDclCntAttributes(type, isConstant);
        for (VarDclCnt dclCnt : varDclCnts.varDclCnts) {
            dclCnt.createSymbolTable(symbolTableVector);
        }
    }
}
