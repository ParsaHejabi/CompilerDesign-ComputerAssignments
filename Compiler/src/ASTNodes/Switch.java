package ASTNodes;

import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class Switch implements SymbolTableCreatable {
    public String identifier;
    public Block block;
    public CaseBlock caseBlock;

    public Switch(String identifier, CaseBlock caseBlock, Block block) {
        this.identifier = identifier;
        this.block = block;
        this.caseBlock = caseBlock;
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {

    }
}
