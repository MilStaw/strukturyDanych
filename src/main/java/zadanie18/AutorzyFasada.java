package zadanie18;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutorzyFasada {
    public List<Map<String, String>> pobierzAutorow() {
        List<Map<String, String>> autorzy = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("id", "ID_" + i);
            map.put("imie", "imie " + i);
            map.put("nazwisko", "nazwisko " + i);
            map.put(AUTHORS_KEYS.ID.getValue(), "ID_" + i);
            map.put(AUTHORS_KEYS.NAME.getValue(), "imie " + i);
            map.put(AUTHORS_KEYS.SURNAME.getValue(), "nazwisko " + i);
            autorzy.add(map);
        }

        return autorzy;
    }

    @Getter
    @AllArgsConstructor
    enum AUTHORS_KEYS {
        ID("id"), NAME("imie"), SURNAME("nazwisko");
        String value;


        public String getValue() {

            return value;
        }
    }
}

