package zadanie18;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static zadanie18.KsiazkiFasada.pobierzKsiazki;

@AllArgsConstructor
public class Ksiazka {

    String title;
    String cena;


    public static void pobierzKsiazki2() {
        List<Map<String, String>> ksiazki = pobierzKsiazki();
        List<Autor> autorList = new ArrayList<>();
    }
    public String toString() {
        return "'" + title + "' - " + cena;
    }



}