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
        while(tmp.succ != null) {
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
        for(SLLNode tmp = first;  tmp != null; tmp=tmp.succ)
            if(o.equals(tmp.element))
                return tmp;
        return null;
    }

    public int size() {
        int counter = 0;
        for (SLLNode tmp = first; tmp != null; tmp = tmp.succ)
            counter++;
        return counter;
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
    }

}
