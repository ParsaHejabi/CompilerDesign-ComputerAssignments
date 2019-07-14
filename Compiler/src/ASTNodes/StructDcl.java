package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class StructDcl implements CodeGeneratable {
    public String identifier;
    public VarDcls varDcls;

    public StructDcl(String identifier, VarDcls varDcls) {
        this.identifier = identifier;
        this.varDcls = varDcls;
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
