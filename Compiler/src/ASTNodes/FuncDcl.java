package ASTNodes;

import ASTNodes.Enums.FuncDclEnum;
import ASTNodes.Interfaces.CodeGeneratable;

import java.util.ArrayList;

public class FuncDcl implements CodeGeneratable {
    public Type type;
    public String identifier;
    public FuncDclEnum funcType;
    public Arguments arguments;

    public FuncDcl(Type type, String identifier, Arguments arguments, FuncDclEnum funcType) {
        this.type = type;
        this.identifier = identifier;
        this.funcType = funcType;
        arguments = arguments;
    }

    @Override
    public String generateCode() {
        return null;
    }
}
