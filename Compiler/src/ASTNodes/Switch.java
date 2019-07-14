package ASTNodes;

public class Switch {
    public String identifier;
    public Block block;
    public CaseBlock caseBlock;

    public Switch(String identifier, CaseBlock caseBlock, Block block) {
        this.identifier = identifier;
        this.block = block;
        this.caseBlock = caseBlock;
    }
}
