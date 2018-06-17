package zadanie18;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

public class KsiazkiFasada {

    public static List<Map<String, String>> pobierzKsiazki() {
        List<Map<String, String>> ksiazki = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(BOOKS_KEYS.TITLE.getValue(), "tutul" + i);
            map.put(BOOKS_KEYS.CENA.getValue(), "" + rand.nextInt(999));
            map.put(BOOKS_KEYS.AUTHOR.getValue(), "ID_" + rand.nextInt(5));
            ksiazki.add(map);
        }

        return ksiazki;
    }

    @Getter
    @AllArgsConstructor
    enum BOOKS_KEYS {
        TITLE("tytul"), CENA("cena"), AUTHOR("autor");
        String value;
    }
}

