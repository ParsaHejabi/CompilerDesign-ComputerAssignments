package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.SymbolTable;

import java.util.ArrayList;
import java.util.Vector;

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
    public String visit(Vector<SymbolTable> symbolTableVector) {
        return null;
    }

    public int size() {
        return args.size();
    }
}
