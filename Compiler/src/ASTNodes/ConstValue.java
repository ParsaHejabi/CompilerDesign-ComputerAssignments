package ASTNodes;

import ASTNodes.Enums.TypeEnum;

public class ConstValue {
    public TypeEnum type;
    public Object value;

    public ConstValue(TypeEnum type, Object value) {
        this.type = type;
        this.value = value;
    }
}
