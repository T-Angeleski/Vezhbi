package VezbiKolok.RemoveDuplicates;

import VezbiKolok.SLLNode;
import VezbiKolok.SLL;

import java.util.Scanner;

//Given SLL, remove all duplicate elements

public class RemoveDuplicates {
    public static void funkcija(SLL<Integer> lista){
        SLLNode<Integer> current = lista.getFirst();
        SLLNode<Integer> tmp;

        while(current != null) {
            tmp = lista.getFirst();

            while(tmp != current) {
                if(tmp.element.equals(current.element)) {
                    lista.delete(tmp);
                    break;
                }
                tmp = tmp.succ;
            }
            current = current.succ;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        SLL<Integer> lista = new SLL();
        for(int i = 0;i < N;i++){
            int broj = input.nextInt();
            lista.insertLast(broj);
        }
        funkcija(lista);
        System.out.println(lista);
    }
}
