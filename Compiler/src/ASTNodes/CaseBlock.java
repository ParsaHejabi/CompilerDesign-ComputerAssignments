package ASTNodes;

import java.util.ArrayList;

public class CaseBlock {
    public ArrayList<Case> cases;

    public CaseBlock() {
        this.cases = new ArrayList<>();
    }

    public void addElement(Case c) {
        cases.add(c);
    }
}
