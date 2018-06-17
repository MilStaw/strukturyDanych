package zadanie19;

import java.util.HashMap;
import java.util.Map;

public class Zadanie19 {

    public static void main(String[] args) {
        Map<Character, Integer> znaki = zliczZnaki("Marek je je je");
        for (Map.Entry<Character, Integer> entry : znaki.entrySet()) {
            if (entry.getValue().equals(1)) {
                System.out.println(entry);
            }
        }

    }


    public static Map<Character, Integer> zliczZnaki(String napis) {
        Map<Character, Integer> znaki = new HashMap<>();
        for (int i = 0; i < napis.length(); i++) {
            Character litera = napis.charAt(i);
            if (znaki.containsKey(litera)) {
                Integer iloscWystapien = znaki.get(litera);
                znaki.put(litera, iloscWystapien + 1);
            } else {
                znaki.put(litera, 1);
            }
        }

        return znaki;
    }
}








