package ASTNodes;

import ASTNodes.Enums.AssignmentType;
import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class Assignment implements SymbolTableCreatable {
    public Expr expr;
    public Variable var;
    public AssignmentType assignmentType;

    public Assignment(Expr expr, Variable var, AssignmentType assignmentType) {
        this.expr = expr;
        this.var = var;
        this.assignmentType = assignmentType;
    }

    public Assignment(Expr expr, Variable var) {
        this.expr = expr;
        this.var = var;
    }

    public Assignment() {
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {

    }
}
