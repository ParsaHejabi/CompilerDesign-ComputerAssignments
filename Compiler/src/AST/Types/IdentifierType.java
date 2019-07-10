package AST.Types;

import AST.Type;

class IdentifierType extends Type {
    @Override
    public String getType() {
        return "id";
    }
}