package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

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
    public void visit(SymbolTable symbolTable) {

    }
}
