package ASTNodes;

import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class Return implements SymbolTableCreatable {
    public Expr expr;

    public Return() {
    }

    public Return(Expr expr) {
        this.expr = expr;
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {

    }
}
