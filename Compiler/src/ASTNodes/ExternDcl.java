package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class ExternDcl implements CodeGeneratable {
    public Type type;
    public String identifier;

    public ExternDcl(Type type, String identifier) {
        this.type = type;
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
