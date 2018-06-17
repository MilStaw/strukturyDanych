package zadanie10;

import com.sun.org.apache.xpath.internal.SourceTree;           ////statyczna metode wywoluje sie na klasie a nie na obiekcie

import java.util.*;

public class Samochod {
    private String marka;
    private int cena;
    private int numerRejestracyjny;
    private boolean daneSamochodu;

    public String getMarka() {

        return marka;
    }

    public void setMarka(String marka) {

        this.marka = marka;
    }

    public int getCena() {

        return cena;
    }

    public void setCena(int cena) {

        this.cena = cena;
    }

    public int getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(int numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public Samochod() {
        this.marka = marka;
        this.cena = cena;
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public static void main(String[] args) {
        LinkedList<Samochod> prom = new LinkedList<>();
        //Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Auto();
    }

    public static void Auto() {
        LinkedList<Samochod> prom = new LinkedList<>();
       /* Scanner scanner = new Scanner(System.in);     /// w tym miejscu pobiera tylko dane jednego auta od uzytkownika
        //String daneSamochodu = scanner.next();
        System.out.println("Podaj marke: ");
        String marka = scanner.nextLine();
        System.out.println("Podaj cene: ");
        int cena = scanner.nextInt();
        System.out.println("Podaj numerRejestracyjny: ");
        int numerRejestracyjny = scanner.nextInt();
        */

        Samochod samochod = new Samochod();                         /// w tym miejscu pobiera kilka danych auta poniewaz jest w petli
        for (int i = 0; i < 4; i++) {
            Scanner scanner = new Scanner(System.in);
            //String daneSamochodu = scanner.next();
            System.out.println("Podaj marke: ");
            String marka = scanner.nextLine();
            System.out.println("Podaj cene: ");
            int cena = scanner.nextInt();
            System.out.println("Podaj numerRejestracyjny: ");
            int numerRejestracyjny = scanner.nextInt();
            //// dodaje wszystkie samochody do promu
            prom.add(samochod);
        }
        System.out.println(prom.size());  //// sprawdza jakie samochody (dane auta) sa na promie
        for (int i = 0; i < 4; i++) {
            System.out.println(prom.get(i).marka);
            System.out.println(prom.get(i).cena);
            System.out.println(prom.get(i).numerRejestracyjny);

        }
        System.out.println(prom.size() > 0);
        if (prom.size() > 0) {
            System.out.println("Prom pelny");
        } else {
            System.out.println("Prom pusty");
        }
    }
}



