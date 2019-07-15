package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.BlockSymbolTable;
import SymbolTables.FunctionSymbolTable;
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
        return "";
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        SymbolTable st;
        if (symbolTableVector.lastElement() instanceof FunctionSymbolTable)
            st = (FunctionSymbolTable) symbolTableVector.lastElement();
        else
            st = (BlockSymbolTable) symbolTableVector.lastElement();
        //symbolTableVector.add(st.getBlock())
        return "";
    }
}
