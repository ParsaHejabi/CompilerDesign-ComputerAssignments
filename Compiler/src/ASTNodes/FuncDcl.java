package ASTNodes;

import ASTNodes.Enums.FuncDclEnum;
import ASTNodes.Interfaces.CodeGeneratable;

public class FuncDcl implements CodeGeneratable {
    public Type type;
    public String identifier;
    public FuncDclEnum funcType;
    public Arguments arguments;
    public Block block;

    public FuncDcl(Type type, String identifier, FuncDclEnum funcType, Arguments arguments, Block block) {
        this.type = type;
        this.identifier = identifier;
        this.funcType = funcType;
        this.arguments = arguments;
        this.block = block;
    }

    public FuncDcl(Type type, String identifier, Arguments arguments, FuncDclEnum funcType) {
        this.type = type;
        this.identifier = identifier;
        this.funcType = funcType;
        this.arguments = arguments;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public FuncDclEnum getFuncType() {
        return funcType;
    }

    public void setFuncType(FuncDclEnum funcType) {
        this.funcType = funcType;
    }

    public Arguments getArguments() {
        return arguments;
    }

    public void setArguments(Arguments arguments) {
        this.arguments = arguments;
    }

    @Override
    public String generateCode() {
        return null;
    }
}
