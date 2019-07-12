package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;

public class ExternDcl implements CodeGeneratable {
    public Type type;
    public String identifier;

    public ExternDcl(Type type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    @Override
    public String generateCode() {
        return null;
    }
}
