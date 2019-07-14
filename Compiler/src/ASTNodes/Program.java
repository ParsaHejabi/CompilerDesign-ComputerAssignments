package ASTNodes;

import ASTNodes.Interfaces.CodeGeneratable;
import ASTNodes.Interfaces.SymbolTableCreatable;
import SymbolTables.SymbolTable;

import java.util.ArrayList;
import java.util.Vector;

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
        return "";
    }

    @Override
    public String visit(Vector<SymbolTable> symbolTableVector) {
        String instructions = "";
        instructions += this.generateCode();

        for (CodeGeneratable cg : programElements) {
            instructions += cg.visit(symbolTableVector);
        }
        return instructions;
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
