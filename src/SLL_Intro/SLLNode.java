package SLL_Intro;

public class SLLNode {
    protected Object element;
    protected SLLNode succ; //reference to next node

    protected SLLNode(Object element, SLLNode succ) {
        this.element = element;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return "SLLNode{" +
                "element=" + element +
                ", succ=" + succ +
                '}';
    }
}
