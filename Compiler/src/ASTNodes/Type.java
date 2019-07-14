package ASTNodes;

import ASTNodes.Enums.TypeEnum;

public class Type {
    public TypeEnum type;

    public Type(TypeEnum type) {
        this.type = type;
    }

    public String getValue() {
        return type.name().toLowerCase();
    }

    public String getTypeForLLVM() {
        if (type.name().toLowerCase() == "long")
            return "i64";
        else if (type.name().toLowerCase() == "int")
            return "i32";
        else if (type.name().toLowerCase() == "char")
            return "i8";
        else if (type.name().toLowerCase() == "boolean" || type.name().toLowerCase() == "bool")
            return "i1";
        else if (type.name().toLowerCase() == "float")
            return "double";
        else if (type.name().toLowerCase() == "string")
            return "i8*";
        else
            return type.name().toLowerCase();
    }
}
