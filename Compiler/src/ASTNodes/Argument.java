package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;

import java.util.ArrayList;

public class Argument implements CodeGeneratable {

    public Type type;
    public String identifier;
    public ArrayList<Argument> arguments;

    public Argument() {
    }

    public Argument(Type type, String identifier) {
        this.type = type;
        this.identifier = identifier;
        this.arguments = new ArrayList<>();
    }

    public void addElement(Argument arg){
        this.arguments.add(arg);
    }

    @Override
    public String generateCode() {
        return null;
    }
}
