package DLL_Intro;

import java.util.Objects;

public class DLL<E> {
    private DLLNode<E> first;
    private DLLNode<E> last;

    public DLL() {
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DLL<?> dll = (DLL<?>) o;
        return Objects.equals(first, dll.first) && Objects.equals(last, dll.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    @Override
    public String toString() {
        return "first=" + first +
                ", last=" + last +
                '}';
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null) {
            last = ins;
        } else {
            first.pred = ins;
        }
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }

        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }

        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null) last = null;
            return tmp.element;
        } else return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null) return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.succ;
                last.succ = null;
                return tmp.element;
            }
        } else return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) return deleteFirst();
        if (node == last) return deleteLast();

        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;
    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;

            if (tmp.element.equals(o)) return tmp;
            else System.out.println("Element not in list");
        } else {
            System.out.println("Empty list");
        }
        return null;
    }

    private int getSize() {
        DLLNode<E> current = first;
        int count = 0;
        while(current != null) {
            count++;
            current = current.succ;
        }
        return count;
    }

    public void printList() {
        DLLNode<E> current = first.succ;
        System.out.println("Double linked list print: ");
        System.out.print(first.element + "<->");
        while (current.succ != null) {
            System.out.print(current.element + "<->");
            current = current.succ;
        }
        System.out.print(current.element + "\n");
    }

    public void deleteDuplicates() {
        DLLNode<E> current = first;
        DLLNode<E> current2;
        while (current != null) {
            current2 = current.succ;
            while (current2 != null) {
                if(current2.occurrences > 1 || current2.element.equals(current.element)) {
                    delete(current2);
                }
                if(current2.element.equals(current.element))
                    current2.occurrences++;

                current2 = current2.succ;
            }
            current = current.succ;
        }
    }


    public void findMiddle() {
        int listLength = getSize();
        double middle = Math.ceil((double)listLength / 2);
        DLLNode<E> current = first;

        while(current != null) {
            if(middle == 1) {
                if(listLength % 2 == 0) {
                    System.out.println("Middle nodes are: " + current.element + " and " + current.succ.element);
                } else {
                    System.out.println("Middle node is: " + current.element);
                }
                return;
            }
            middle--;
            current = current.succ;
        }
    }



    public static void main(String[] args) {
        System.out.println("Testing DLL insert and print");
        DLL<String> theGang = new DLL<>();
        theGang.insertLast("Asim");
        theGang.insertLast("Androxus");
        theGang.insertLast("PureFist");
        theGang.insertLast("Hexodian");
//        theGang.insertLast("Walkorion");
        theGang.insertLast("Aerraa");
        theGang.printList();

        System.out.println("------------Test insert after--------");
        DLLNode<String> insNode = theGang.find("PureFist");
        theGang.insertAfter("Gragas", insNode);
        theGang.printList();

        System.out.println("--------TEST DELETE DUPLICATES------");
        DLL<Integer> dll = new DLL<>();
        dll.insertLast(2);
        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(4);
        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(6);
        dll.insertLast(7);
        dll.insertLast(9);
        //1 2 1 4 1 2 5   ->   1 2 4 5
        dll.printList();
        dll.deleteDuplicates();
        dll.printList();

        System.out.println("-----------TEST MIDDLE--------");
        theGang.printList();
        theGang.findMiddle();
    }
}
