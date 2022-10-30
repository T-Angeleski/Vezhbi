package SLL_Intro;

import org.w3c.dom.ls.LSOutput;

public class SLL {
    private SLLNode first;

    public SLL() {
        //kreirame prazna lista
        this.first = null;
    }


    public void printNodes() {
        System.out.print("The SLL Nodes are: ");
        for (SLLNode tmp = first; tmp != null; tmp = tmp.succ) {
            if (tmp.succ == null) {
                System.out.print(tmp.element);
                break;
            }
            System.out.print(tmp.element + "->");
        }
        System.out.println();
    }

    public void insertFirst(Object o) {
        //Vmetni element na skros pocetok na lista
        SLLNode nov = new SLLNode(o, null);
        //napravi nov, data da bide od O, pokazhuva kon null
        nov.succ = first; // noviot da pokazhuva kon first
        first = nov; // noviot da stane prv
    }

    public void insert(Object o, SLLNode posle) {
        // Ash->Androxus
        //  Ash - Asim - Androxus
        // Asim->null
        // Asim -> Androxus
        // Ash -> Asim
        SLLNode ins = new SLLNode(o, null);
        if (posle == null) {
            ins.succ = first;
            first = ins;
        } else {
            ins.succ = posle.succ;
            posle.succ = ins;
        }
    }

    public void insertLast(Object o) {
        SLLNode tmp = first;
        while (tmp.succ != null) {
            tmp = tmp.succ;
        }
        SLLNode ins = new SLLNode(o, null);
        tmp.succ = ins;
    }

    public SLLNode find(Object o) {
//        if (first != null) {
//            SLLNode tmp = first;
//            while (!tmp.element.equals(o) && tmp.succ != null)
//                tmp = tmp.succ;
//
//            if (tmp.element.equals(o))
//                return tmp;
//            else
//                System.out.println("Elementot ne postoi");
//
//        } else {
//            System.out.println("Listata e prazna");
//        }
//        return null;
        for (SLLNode tmp = first; tmp != null; tmp = tmp.succ)
            if (o.equals(tmp.element))
                return tmp;
        return null;
    }

    public int size() {
        int counter = 0;
        for (SLLNode tmp = first; tmp != null; tmp = tmp.succ)
            counter++;
        return counter;
    }

    public void deleteNode(Object o) {
        //1->2->3->4-5, sakame 3 da izbriseme
        // na 2 sledbenik da bide na 3 sledbenikot
        SLLNode tmp = first;

        while (tmp.succ != null) {
            if (tmp.succ.element == o) {
                tmp.succ = tmp.succ.succ;
            }
            tmp = tmp.succ;
        }
    }

    public void reverseList() {
        SLLNode current = first;
        SLLNode prev = null;
        SLLNode next;

        while(current != null) { // 1->2->3->4->5
            next = current.succ; //
            current.succ = prev;
            prev = current;
            current = next;
        }
        first = prev;
    }


    public static void main(String[] args) {
        SLL leagueChamps = new SLL(); //
        leagueChamps.insertFirst("Pyke");
        leagueChamps.insertFirst("Jhin");
        leagueChamps.insertFirst("Asim");
        leagueChamps.insertFirst("H");
        leagueChamps.printNodes();

        System.out.println("----------------------TESTING INSERT AFTER----------------------");
        SLLNode ins = leagueChamps.find("Asim");
        leagueChamps.insert("Androxus", ins);
        leagueChamps.printNodes();

//        System.out.println("TEST - FIND NA ELEMENT SHO NE POSTOI");
//        SLLNode h = leagueChamps.find("Hamza");
//        leagueChamps.insert(h, ins); //NE RABOTE KAKO SHO TREBAA
//        leagueChamps.printNodes();

        System.out.println("----------------------TESTING SIZE()----------------------");
        System.out.println(leagueChamps.size());

        System.out.println("----------------------TEST INSERT LAST----------------------");
        leagueChamps.insertLast("Hexodian");
        leagueChamps.printNodes();

        System.out.println("----------------------TEST DELETE NODE----------------------");
        System.out.println("List before delete jhin");
        leagueChamps.printNodes();
        leagueChamps.deleteNode("Jhin");
        System.out.println("List after delete jhin");
        leagueChamps.printNodes();


        System.out.println("----------------------TEST REVERSE SLL (pomos)----------------------");
        SLL numList = new SLL();
        numList.insertFirst(1);
        numList.insertLast(2);
        numList.insertLast(3);
        numList.insertLast(4);
        numList.insertLast(5);
        numList.insertLast(6);
        System.out.println("List before sort");
        numList.printNodes();
        numList.reverseList();
        System.out.println("List after sort");
        numList.printNodes();


    }

}
