package ASTNodes;

import ASTNodes.Enums.TypeEnum;

public class ConstValue extends Expr {
    public Type type;
    public Object value;

    public ConstValue(Type type, Object value) {
        this.type = type;
        this.value = value;
    }
}
