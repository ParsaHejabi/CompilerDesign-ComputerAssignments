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
        return "";
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        String temp = "%struct.";
        temp.concat(identifier);
        temp.concat(" = type {");

        int row = varDcls.size();
        for (int i = 0; i < row; i++) {
            // Accept VarDecls
            temp += varDcls.getElement(i);

            for (int j = 0; j < varDcls.getElement(i).varDclCnts.size(); j++) {
                //not array in struct
                if (varDcls.getElement(i).varDclCnts.getElement(j).expr == null) {

                    temp.concat(varDcls.getElement(i).type.getValue());

                    if ((i + 1) < row || (j + 1) < varDcls.size()) {
                        temp.concat(",");
                    }
                } else {
                    //TODO array in struct
                }
            }
        }
        return temp;
    }
}
