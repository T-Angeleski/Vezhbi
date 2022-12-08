package StackQueue.KorektnostZagradi;


import java.util.NoSuchElementException;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }


    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }


    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}


public class CheckBrackets {

    private static boolean daliZagraditeSePravilni(String phrase) {
        ArrayStack<Character> stack = new ArrayStack<>(100);

        for (int i = 0; i < phrase.length(); i++) {
            char current = phrase.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else if (current == ')' || current == '}' || current == ']') {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (!daliSoodvetni(left, current)) return false;
            }

        }
        return stack.isEmpty();
    }

    private static boolean daliSoodvetni(char left, char right) {
        switch (left) {
            case '(':
                return right == ')';
            case '{':
                return right == '}';
            case '[':
                return right == ']';
        }
        return false;
    }

    public static void main(String[] args) {
        String phrase = "s x (s - [a]) x (s - b) x (s - c)";

        System.out.println(phrase + " ima "
                + (daliZagraditeSePravilni(phrase) ? "korektni" : "nekorektni")
                + " zagradi.");
    }


}
