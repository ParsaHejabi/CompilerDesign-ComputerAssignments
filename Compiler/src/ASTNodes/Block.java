package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.BlockSymbolTable;
import SymbolTables.FunctionSymbolTable;
import SymbolTables.BlockSymbolTable;
import SymbolTables.FunctionSymbolTable;
import SymbolTables.SymbolTable;

import java.util.ArrayList;
import java.util.Vector;

public class Block implements CodeGeneratable, SymbolTableCreatable {
    public static int blockNumber = 0;
    public ArrayList<Object> varDcls_statements;

    public Block() {
        this.varDcls_statements = new ArrayList<>();
    }

    public Block(ArrayList<Object> varDcls_statements) {
        this.varDcls_statements = varDcls_statements;
    }

    @Override
    public String generateCode() {
        return "";
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        SymbolTable st;
        if (symbolTableVector.lastElement() instanceof FunctionSymbolTable)
            st = (FunctionSymbolTable) symbolTableVector.lastElement();
        else
            st = (BlockSymbolTable) symbolTableVector.lastElement();
        //symbolTableVector.add(st.getBlock())
        return "";
    }

    @Override
    public void createSymbolTable(Vector<SymbolTable> symbolTableVector) {
        SymbolTable table = symbolTableVector.lastElement();
        String blockName = makeUniqueBlockName();
        table.addBlock(blockName, table);
        symbolTableVector.add(symbolTableVector.lastElement().getBlock(blockName));

        for (Object o : varDcls_statements) {
            if (o instanceof VarDcl) {
                ((VarDcl) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof Assignment) {
                ((Assignment) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof MethodCall) {
                ((MethodCall) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof If) {
                ((If) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof Switch) {
                ((Switch) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof For) {
                ((For) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof Repeat) {
                ((Repeat) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof Foreach) {
                ((Foreach) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof Return) {
                ((Return) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof Break) {
                ((Break) o).createSymbolTable(symbolTableVector);
            } else if (o instanceof Continue) {
                ((Continue) o).createSymbolTable(symbolTableVector);
            }
        }
    }

    public static String makeUniqueBlockName() {
        return "Block#" + blockNumber++;
    }
}
