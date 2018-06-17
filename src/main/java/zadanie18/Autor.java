package zadanie18;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

class Autor {
    String id;
    String name;
    String surname;

    List<Book> ksiazki = new ArrayList<>();

    public Autor(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    public boolean isPopular(){
        if (ksiazki.size()>=5){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "(" + id + ')' + name + ' ' + surname + ": " + ksiazki + "\n";
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }
}



