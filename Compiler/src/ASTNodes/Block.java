package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

import java.util.ArrayList;
import java.util.Vector;

public class Block implements CodeGeneratable {
    public ArrayList<Object> varDcls_statements;

    public Block() {
        this.varDcls_statements = new ArrayList<>();
    }

    public Block(ArrayList<Object> varDcls_statements) {
        this.varDcls_statements = varDcls_statements;
    }

    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        return null;
    }
}
