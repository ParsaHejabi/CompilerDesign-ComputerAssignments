package ASTNodes;

import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class MethodCall extends Expr implements SymbolTableCreatable {
    public String Identifier;
    public Parameters parameters;

    public MethodCall(String identifier, Parameters parameters) {
        Identifier = identifier;
        this.parameters = parameters;
    }

    public MethodCall(String identifier) {
        Identifier = identifier;
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {

    }
}
