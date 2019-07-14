package ASTNodes;

public class MethodCall {
    public String Identifier;
    public Parameters parameters;

    public MethodCall(String identifier, Parameters parameters) {
        Identifier = identifier;
        this.parameters = parameters;
    }

    public MethodCall(String identifier) {
        Identifier = identifier;
    }
}
