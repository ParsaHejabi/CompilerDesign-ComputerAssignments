package ASTNodes;

import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class For implements SymbolTableCreatable {
    public Assignment assignment;
    public Expr expr;
    public Block block;
    public AssignmentOrExpression assignmentOrExpression;

    public For(Expr expr, Block block, AssignmentOrExpression assignmentOrExpression) {
        this.expr = expr;
        this.block = block;
        this.assignmentOrExpression = assignmentOrExpression;
    }

    public For(Assignment assignment, Expr expr, Block block, AssignmentOrExpression assignmentOrExpression) {
        this.assignment = assignment;
        this.expr = expr;
        this.block = block;
        this.assignmentOrExpression = assignmentOrExpression;
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {

    }
}
