package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;

import java.util.ArrayList;

public class StructDcl implements CodeGeneratable {
    public String identifier;
    public ArrayList<VarDcl> varDcls;

    public StructDcl(String identifier) {
        this.identifier = identifier;
        varDcls = new ArrayList<>();
    }

    public void addElement(VarDcl vd){
        varDcls.add(vd);
    }

    @Override
    public String generateCode() {
        return null;
    }
}
