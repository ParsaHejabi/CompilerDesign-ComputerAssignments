package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import SymbolTables.ProgramSymbolTable;
import SymbolTables.SymbolTable;
import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTableVariable;

import java.lang.reflect.Method;
import java.util.Vector;

public class VarDclCnt implements CodeGeneratable, SymbolTableCreatable {
    public boolean isConstant;
    public String identifier;
    public Type type;
    public Expr expr;

    public VarDclCnt(String identifier, Expr expr) {
        this.identifier = identifier;
        this.expr = expr;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public void setConstant(boolean constant) {
        isConstant = constant;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String generateCode() {
        return "";
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        String instructions = "";
        if (expr != null) {
            instructions += expr.visit(symbolTableVector);
        }
        String varType = type.getTypeForLLVM();
        boolean isLocal = false;
        if (!((symbolTableVector.lastElement()) instanceof ProgramSymbolTable)) {
            isLocal = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (isLocal) {
            //stringBuilder.append("%" + identifier + "_ptr = alloca ");
            // TODO add for n dimention array
            if (expr == null) {
                varType = type.getTypeForLLVM();
                stringBuilder.append("%" + identifier + "_ptr = alloca " + varType);
            } else if (expr instanceof ConstValue) {
                varType = ((ConstValue) expr).type.getTypeForLLVM();
                stringBuilder.append("%" + identifier + "_ptr = alloca " + varType + "\n");
                stringBuilder.append("store " + varType + " " + ((ConstValue) expr).value + ", " + varType + "* %" + identifier + "_ptr" + "\n");

            }

            return stringBuilder.toString();
        } else {
            //stringBuilder.append("@" + identifier + "_ptr = alloca ");
            // TODO add for n dimention array
            if (expr == null) {
                varType = type.getTypeForLLVM();
                stringBuilder.append("@" + identifier + "_ptr = alloca " + varType);
            } else if (expr instanceof ConstValue) {
                varType = ((ConstValue) expr).type.getTypeForLLVM();
                stringBuilder.append("@" + identifier + "_ptr = alloca " + varType + "\n");
                stringBuilder.append("store " + varType + " " + ((ConstValue) expr).value + ", " + varType + "* %" + identifier + "_ptr" + "\n");
            }


        }
        return stringBuilder.toString();

    }

    @Override
    public void createSymbolTable(SymbolTable symbolTable) {
        symbolTable.addSymbolTableVariable(identifier, type);

        SymbolTableVariable table = symbolTable.lookupSymbolTableVariable(identifier);

        if (expr != null) {
            table.exprList.exprs.add(expr);
        }
    }
}
