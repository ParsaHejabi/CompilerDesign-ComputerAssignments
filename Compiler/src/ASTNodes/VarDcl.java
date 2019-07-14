package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;

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
    public void visit() {
        this.generateCode();

        for (VarDclCnt dclCnt : varDclCnts.varDclCnts) {
            dclCnt.visit();
        }
    }
}
