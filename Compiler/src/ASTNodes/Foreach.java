package ASTNodes;

import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class Foreach implements SymbolTableCreatable {
    public String id1, id2;

    public Foreach(String id1, String id2, Block block) {
        this.id1 = id1;
        this.id2 = id2;
        this.block = block;
    }

    public Block block;

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {

    }
}
