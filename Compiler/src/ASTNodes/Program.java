package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import ASTNodes.Interfaces.SymbolTableCreatable;

import java.util.ArrayList;

public class Program implements CodeGeneratable, SymbolTableCreatable {

    public ArrayList<CodeGeneratable> programElements;

    public Program() {
        programElements = new ArrayList<>();
    }

    public void addElement(CodeGeneratable o) {
        this.programElements.add(o);
    }

    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public void visit() {
        this.generateCode();

        for (CodeGeneratable cg : programElements) {
            cg.visit();
        }
    }

    @Override
    public void createSymbolTable() {
        for (CodeGeneratable cg : programElements) {
            if (cg instanceof SymbolTableCreatable) {
                SymbolTableCreatable symbolTableCreatable = (SymbolTableCreatable) cg;
                symbolTableCreatable.createSymbolTable();
            }
        }
    }
}
