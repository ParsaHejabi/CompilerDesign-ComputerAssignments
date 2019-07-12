package ASTNodes;

import java.util.ArrayList;

public class Block {
    public ArrayList<Object> varDcls_statements;

    public Block() {
        this.varDcls_statements = new ArrayList<>();
    }

    public Block(ArrayList<Object> varDcls_statements) {
        this.varDcls_statements = varDcls_statements;
    }
}
