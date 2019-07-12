package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;

import java.util.ArrayList;

public class Argument implements CodeGeneratable {

    public Type type;
    public String identifier;

    public Argument() {
    }

    public Argument(Type type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    @Override
    public String generateCode() {
        return null;
    }
}
