package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class Argument implements CodeGeneratable {

    public Type type;
    public String identifier;

    public Argument() {
    }

    public Argument(Type type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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
