package ASTNodes;

import ASTNodes.Enums.FuncDclType;
import ASTNodes.Interfaces.CodeGeneratable;

import java.util.ArrayList;

public class FuncDcl implements CodeGeneratable {
    public Type type;
    public String identifier;
    public FuncDclType funcType;
    public ArrayList<Argument> Arguments;

    public FuncDcl(Type type, String identifier, FuncDclType funcType, ArrayList<Argument> arguments) {
        this.type = type;
        this.identifier = identifier;
        this.funcType = funcType;
        Arguments = arguments;
    }

    @Override
    public String generateCode() {
        return null;
    }
}
