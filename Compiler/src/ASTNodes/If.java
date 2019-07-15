package ASTNodes;


import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class If implements SymbolTableCreatable {
    public Expr expr;
    public Block ifBlock, elseBlock;

    public If(Expr expr, Block ifBlock, Block elseBlock) {
        this.expr = expr;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    public If(Expr expr, Block ifBlock) {
        this.expr = expr;
        this.ifBlock = ifBlock;
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {

    }
}
