package ASTNodes;

import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class Repeat implements SymbolTableCreatable {
    public Block block;
    public Expr expr;

    public Repeat(Block block, Expr expr) {
        this.block = block;
        this.expr = expr;
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {

    }
}
