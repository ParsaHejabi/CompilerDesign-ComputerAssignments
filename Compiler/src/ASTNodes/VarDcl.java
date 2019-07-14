package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

public class VarDcl implements CodeGeneratable {
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
    public void visit(SymbolTable symbolTable) {
        this.generateCode();

        for (VarDclCnt dclCnt : varDclCnts.varDclCnts) {
            dclCnt.visit();
        }
    }
}
