package ASTNodes;

import ASTNodes.Enums.FuncDclEnum;
import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.FunctionSymbolTable;
import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.ProgramSymbolTable;
import SymbolTables.SymbolTable;

import java.util.Vector;

public class FuncDcl implements CodeGeneratable, SymbolTableCreatable {
    public Type type;
    public String identifier;
    public FuncDclEnum funcType;
    public Arguments arguments;
    public Block block;

    public FuncDcl(Type type, String identifier, Arguments arguments, FuncDclEnum funcType, Block block) {
        this.type = type;
        this.identifier = identifier;
        this.funcType = funcType;
        this.arguments = arguments;
        this.block = block;
    }

    public FuncDcl(Type type, String identifier, Arguments arguments, FuncDclEnum funcType) {
        this.type = type;
        this.identifier = identifier;
        this.funcType = funcType;
        this.arguments = arguments;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public FuncDclEnum getFuncType() {
        return funcType;
    }

    public void setFuncType(FuncDclEnum funcType) {
        this.funcType = funcType;
    }

    public Arguments getArguments() {
        return arguments;
    }

    public void setArguments(Arguments arguments) {
        this.arguments = arguments;
    }

    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        String instructions = "";
        symbolTableVector.add(symbolTableVector.lastElement().getBlock(identifier));

        if (funcType == FuncDclEnum.DECLARE) {
            if (arguments != null) {
                if (arguments.args != null) {
                    for (Argument arg : arguments.args) {
                        instructions += arg.visit(symbolTableVector);
                    }
                }

            }
            return instructions;
        } else {
            String args = "";
            if (arguments != null) {
                if (arguments.args != null) {
                    int i = 0;
                    for (Argument arg : arguments.args) {
                        arg.visit(symbolTableVector);
                        // some LLVM code
                        String argType = arg.type.getValue();
                        String argName = arg.identifier;
                        String argument = arg.type.getTypeForLLVM() + "* %" + argName + "_ptr";
                        //String arg = getTypeForLLVM(argType) + " %" + argName;
                        args = args.concat(((i == 0) ? "" : ",") + argument);
                        i++;
                    }
                }

            }
            String returnType = type.getValue();
            FunctionSymbolTable fst = symbolTableVector.firstElement().getCurrentFunctionSymbolTable();
            String functionNumber = "";
            if (fst != null && !identifier.equals("main")) {
                functionNumber = "." + fst.num;
            }

            String llvm = "define " + type.getTypeForLLVM() + " @" + identifier + functionNumber + "(" + args + ") {";
            instructions += llvm + "\n";

            block.visit(symbolTableVector);

            if (returnType.equals("void")) {
                instructions += "ret void\n";
            }
            instructions += "}\n";
        }
        symbolTableVector.remove(symbolTableVector.size() - 1);
        return instructions;
    }

    @Override
    public void createSymbolTable(SymbolTable symbolTable) {
        ProgramSymbolTable programSymbolTable = (ProgramSymbolTable) symbolTable;

        // Has no blocks
        if (funcType == FuncDclEnum.DECLARE) {

        } else {

//            block.visit(symbolTable.getBlock(identifier));
        }
    }
}
