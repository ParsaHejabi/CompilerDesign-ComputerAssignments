package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

import java.util.ArrayList;

public class Arguments implements CodeGeneratable {
    public ArrayList<Argument> args;

    public Arguments() {
        args = new ArrayList<>();
    }

    public void addElement(Argument arg) {
        args.add(arg);
    }

    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public void visit(SymbolTable symbolTable) {

    }
}
