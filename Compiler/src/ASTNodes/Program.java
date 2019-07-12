package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;

import java.util.ArrayList;

public class Program implements CodeGeneratable {

    public ArrayList<Object> programElements;

    public Program() {
        programElements = new ArrayList<>();
    }

    public void addElement(Object o) {
        this.programElements.add(o);
    }

    @Override
    public String generateCode() {
        return null;
    }
}
