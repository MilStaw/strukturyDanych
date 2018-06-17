package zadanie7;


import java.util.*;

public class Zadanie7 {
    public static void main(String[] args) {   ///// w get arrayList bedzie lepszy    nat.w dodawaniu i usuwaniu linkList na poczatek listy jest lepsze
        int COUNTER = 50000;       //// przez dodanie int counter nie musze zmieniac wartosci w kazdym kodzie.
        List<Integer> Linkedlist = new ArrayList<>();
        Random random = new Random();
        long start = new Date().getTime();
        for (int i = 0; i < COUNTER; i++) {
            Linkedlist.add(random.nextInt());
        }
        System.out.println("Dodaj na koncu: " + (new Date().getTime() - start) + "ms");

        Linkedlist = new ArrayList<>();
        start = new Date().getTime();
        for (int i = 0; i < COUNTER; i++) {
            Linkedlist.add(0, random.nextInt());
        }
        System.out.println("Dodoaj na poczatku: " + (new Date().getTime() - start) + "ms");

        Linkedlist = new LinkedList<>();
        random = new Random();
        start = new Date().getTime();
        for (int i = 0; i < COUNTER; i++) {
            Linkedlist.add(random.nextInt());
        }
        System.out.println("LL Dodaj na koncu: " + (new Date().getTime() - start) + "ms");

        Linkedlist = new LinkedList<>();
        start = new Date().getTime();
        for (int i = 0; i < COUNTER; i++) {
            Linkedlist.add(0, random.nextInt());
        }
        System.out.println("LL Dodoaj na poczatku: " + (new Date().getTime() - start) + "ms");


    }
}
