package VezbiKolok.RabotniciPlataSLL;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNode {
    protected int id;
    protected int plata;
    protected SLLNode succ;

    public SLLNode(int id, int plata, SLLNode succ) {
        this.id = id;
        this.plata = plata;
        this.succ = succ;
    }
}

class SLL {
    private SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;

            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else return 0;
    }

    public void insertFirst(int id, int plata) {
        SLLNode ins = new SLLNode(id, plata, first);
        first = ins;
    }

    public void insertLast(int id, int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, plata, null);
            tmp.succ = ins;
        } else insertFirst(id, plata);
    }

    public SLLNode getFirst() {
        return first;
    }


    public SLL brisi_pomali_od(int iznos) {
        SLLNode current = first;
        SLLNode prev = first; // ni treba za prev.succ = current.succ

        while (current != null) {
            if (current.plata < iznos) {
                //Posebna situacija za first node kaj SLL
                if (current == first) {
                    first = current.succ;
                    prev = first;
                    current = first;
                } else {
                    prev.succ = current.succ;
                    current = current.succ;
                }
            } else { // ne treba brisenje
                prev = current;
                current = current.succ;
            }
        }

        return this;
    }

    public SLL sortiraj_opagacki() {
        //najmal najdesno ( ne mozeme nalevo da odime)
        SLLNode node;
        SLLNode prev1, prev2, next;
        // p1 -> za swap, p2 -> za da odrzime tek na vrtenje
        // p2 -> p1 -> node -> tmp

        for (int i = 0; i < length(); i++) {

            node = first.succ;
            prev1 = prev2 = first;

            while (node != null) {
                if (prev1.id < node.id) {
                    next = node.succ;
                    node.succ = prev1;
                    prev1.succ = next;

                    if (prev1 == first) {
                        first = node;
                    } else {
                        prev2.succ = node;
                    }

                    prev2 = node;
                    node = next;
                } else {
                    if (prev1 != first) {
                        prev2 = prev2.succ;
                    }

                    prev1 = prev1.succ;
                    node = node.succ;
                }
            }
        }

        return this;
    }


    public void pecati(SLL lista) {
        SLLNode p = lista.first;
        while (p != null) {
            System.out.println(p.id + " " + p.plata);
            p = p.succ;
        }
    }


}


public class SLLKompanija {


    public static void main(String[] args) throws IOException {
        SLL lista1 = new SLL();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        for (int i = 0; i < N; i++) {
            s = stdin.readLine();
            String s1 = stdin.readLine();
            lista1.insertLast(Integer.parseInt(s), Integer.parseInt(s1));
        }
        s = stdin.readLine();

        lista1 = lista1.brisi_pomali_od(Integer.parseInt(s));
        if (lista1 != null) {
            lista1 = lista1.sortiraj_opagacki();
            lista1.pecati(lista1);
        }
    }
}
