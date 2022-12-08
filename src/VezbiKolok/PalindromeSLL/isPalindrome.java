package VezbiKolok.PalindromeSLL;

import VezbiKolok.SLL;
import VezbiKolok.SLLNode;

import java.util.Scanner;

public class isPalindrome {

    private static int testPalindrome(SLL<Integer> list) {
        SLL<Integer> mirroredList = new SLL<>();
        SLLNode<Integer> tmpOriginal = list.getFirst();


        while(tmpOriginal != null) {
            mirroredList.insertLast(tmpOriginal.element);
            tmpOriginal = tmpOriginal.succ;
        }

        mirroredList.mirror();

        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> mirr = mirroredList.getFirst();

        while (tmp != null && mirr != null) {
            if (!tmp.element.equals(mirr.element))
                return -1;
            tmp = tmp.succ;
            mirr = mirr.succ;
        }
        return 1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++)
            list.insertLast(in.nextInt());
        in.close();
        System.out.println(testPalindrome(list));
    }


}
