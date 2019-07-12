package ASTNodes;

import java.util.ArrayList;

public class Arguments {
    public ArrayList<Argument> args;

    public Arguments() {
        args = new ArrayList<>();
    }

    public void addElement(Argument arg) {
        args.add(arg);
    }
}
