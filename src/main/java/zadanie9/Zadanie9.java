package zadanie9;

import java.util.LinkedList;

public class Zadanie9 {
    public static void main(String[] args) {
        /*LinkedList<Integer>LinkedList = new LinkedList<>();

        LinkedList.push(1);
        LinkedList.push(2);
        LinkedList.push(3);
        LinkedList.push(4);


        System.out.println(LinkedList.pop());     ///pop zwraca i usuwa jednoczesnie
        System.out.println(LinkedList.pop());
        System.out.println(LinkedList.pop());
        */
        LinkedList<String> stos = new LinkedList<>();
        String napis = "Komp";

        for (int i = 0; i < napis.length(); i++) {
            stos.push(String.valueOf(napis.charAt(i)));       /////
        }

        int count = stos.size();
        for (int i = 0; i < count; i++) {
            System.out.print(stos.pop());
        }

        Integer[] numbers = new Integer[] { 1, 2, 3, 4, 5 };           //// odwracanie cyfr na stosie
        LinkedList<Integer> stosNumbers = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            stosNumbers.push(numbers[i]);
        }

        int countNumbers = stosNumbers.size();
        for (int i = 0; i < countNumbers; i++) {
            System.out.println(stosNumbers.pop());
        }

    }
}
