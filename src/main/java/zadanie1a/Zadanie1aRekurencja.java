package zadanie1a;

import java.io.File;
import java.util.Scanner;


class MyArrayList {
    private static final int CAPACITY = 10000;
    private Integer[] numbers = new Integer[CAPACITY];
    private int index = 0;

    public Integer get(Integer i)
    {
        return numbers[i];
    }

    public void add(Integer number) {
        if (index >= numbers.length) {
            copy(2 * numbers.length);
        }
        numbers[index++] = number;
    }

    public void remove(Integer x) {
        for (int i = 0; i < size() - 1; i++) {
            if (x.equals(get(i))) {
                numbers[i] = null;
            }
        }

        copy(size());
    }

    private void removeRecur(Integer x, int i) {
        if (i < 0) {
            return;
        }
        if (x.equals(get(i))) {
            numbers[i] = null;
        }
        removeRecur(x, i - 1);
    }

    public void removeRecurWithCopy(Integer x) {
        removeRecur(x, index);
        copy(size());
    }

    private void copy(int newSize) {
        Integer[] temp = new Integer[newSize];
        int tabSize = size();
        int tempIndex = 0;

        for (int i = 0; i < tabSize - 1; i++) {
            if (get(i) != null) {
                temp[tempIndex++] = get(i);
            }
        }
        index = tempIndex;
        numbers = temp;
    }

    public int size() {
        return index + 1;
    }
}

public class Zadanie1aRekurencja {

    public static void main(String[] args) {
        MyArrayList words = new MyArrayList();
        words.add(4);
        words.add(3);
        words.add(5);
        words.add(10);
        words.add(4);
        words.add(7);
        words.add(8);
        words.add(4);

        System.out.println("init: ");
        for (int i = 0; i < words.size() - 1; i++) {
            System.out.print(words.get(i) + ", ");
        }

        words.removeRecurWithCopy(4);

        System.out.println();
        System.out.println("After remove `4`: ");
        for (int i = 0; i < words.size() - 1; i++) {
            System.out.print(words.get(i) + ", ");
        }
    }
}





