package AST;

import java.util.ArrayList;

public class Program extends AbstractNode {
    public ArrayList list;

    public Program(Object o) {
        list = new ArrayList();
        list.add(o);
    }

    public void addElement(Object o) {
        list.add(o);
    }

    public Object elementAt(int i) {
        return list.get(i);
    }

    public int size() {
        return list.size();
    }

    @Override
    public void CG() {
        super.CG();
    }

    @Override
    public void CreateSymbolTable() {
        super.CreateSymbolTable();
    }
}