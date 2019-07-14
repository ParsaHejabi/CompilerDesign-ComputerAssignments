package ASTNodes;

public class Case {
    public ConstValue constValue;
    public Block block;

    public Case(ConstValue constValue, Block block) {
        this.constValue = constValue;
        this.block = block;
    }
}