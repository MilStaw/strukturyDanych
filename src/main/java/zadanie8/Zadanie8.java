package zadanie8;

import java.util.LinkedList;

public class Zadanie8 {
    public static void main(String[] args) {

        System.out.println(bin(16));
    }
    public static LinkedList<Integer>bin(Integer n){
        LinkedList<Integer>stos = new LinkedList<>();
        Integer m = n;
        for (;m>0;) {
            stos.push(m % 2);

            m = m / 2;
        }
        return stos;
    }

   // public static void main(String[] args) {
       // System.out.println(bin(6));    /// dla 8 bedzie 1000            nie ma znaczenia czy psvm damy na poczatku czy na koncu
    }
