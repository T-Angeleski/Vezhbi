package DLL_Intro;

public class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred;
    protected DLLNode<E> succ;
    protected int occurrences;

    public DLLNode(E element, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = element;
        this.pred = pred;
        this.succ = succ;
        occurrences = 1;
    }

    @Override
    public String toString() {
        return "element=" + element +
                ", occurrences=" + occurrences +
                '}';
    }
}
