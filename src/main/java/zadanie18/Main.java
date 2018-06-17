package zadanie18;

import java.util.List;

public class Main {

    private static Autor[] autor    ;

    public static void main(String[] args) {
        List<Autor> authors = new Biblioteka().getAuthors();
        for (Autor a : autor) {
            System.out.print("(" + a.getId() + ") ");
            if (a.isPopular()) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            System.out.println(a.getSurname());
        }
//        System.out.println(new Biblioteka().getAuthors());
    }
}


