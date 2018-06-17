package zadanie18;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteka {
    private AutorzyFasada autorzyFasada = new AutorzyFasada();
    private KsiazkiFasada ksiazkiFasada = new KsiazkiFasada();

    public List<Autor> getAuthors() {
        Map<String, List<Ksiazka>> mappedBooks = mapBooks();
        List<Autor> mappedAuthors = mapAuthors();

        List<Autor> autors = new ArrayList<>();

        return autors;
    }

    private List<Autor> mapAuthors() {
        List<Map<String, String>> autorzy = autorzyFasada.pobierzAutorow();
        List<Autor> autorList = new ArrayList<>();
        for (Map<String, String> map : autorzy) {
            autorList.add(new Autor(
                    map.get(AutorzyFasada.AUTHORS_KEYS.ID.getValue()),
                    map.get(AutorzyFasada.AUTHORS_KEYS.NAME.getValue()),
                    map.get(AutorzyFasada.AUTHORS_KEYS.SURNAME.getValue())
            ));
        }

        return autorList;
    }

    private Map<String, List<Ksiazka>> mapBooks() {
        List<Map<String, String>> ksiazki = ksiazkiFasada.pobierzKsiazki();
        Map<String, List<Ksiazka>> mappedBooks = new HashMap<>();
        for (Map<String, String> map : ksiazki) {
            String authorId = map.get(KsiazkiFasada.BOOKS_KEYS.AUTHOR.getValue());
            if (!mappedBooks.containsKey(authorId)) {
                mappedBooks.put(authorId, new ArrayList<>());
            }

            List < Ksiazka > oldBooks = mappedBooks.get(authorId);
            oldBooks.add(new Ksiazka(
                    map.get(KsiazkiFasada.BOOKS_KEYS.TITLE.getValue()),
                    map.get(KsiazkiFasada.BOOKS_KEYS.CENA.getValue())
            ));
        }

        return mappedBooks;
    }
}


