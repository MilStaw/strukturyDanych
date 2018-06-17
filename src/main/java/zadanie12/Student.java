package zadanie12;

        import lombok.AllArgsConstructor;
        import lombok.Getter;

        import javax.rmi.CORBA.StubDelegate;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.Objects;
        import java.util.Scanner;
        import java.util.Set;

        @Getter
@AllArgsConstructor
class Student {
            private final String imie;
            private final String nazwisko;
            private final Integer nrIndeksu;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Student student2 = (Student) o;
                return Objects.equals(imie, student2.imie) &&
                        Objects.equals(nazwisko, student2.nazwisko) &&
                        Objects.equals(nrIndeksu, student2.nrIndeksu);
            }

            @Override
            public int hashCode() {
                return nrIndeksu;
            }


            public static class Main2 {
                public static void main(String[] args) {
                    List<Student> student2List = new ArrayList<>();
                    while (true) {
                        student2List.add(pobierzStudentow());
                        System.out.print("Czy pobierać dalej: ");
                        if (new Scanner(System.in).nextLine().equals("n")) {
                            break;
                        }
                    }

                    Map<Student, Integer> iloscGodzin = new HashMap<>();
                    while (true) {
                        Integer nrIndeksu = pobierzIndeks();
                        System.out.print("Czy pobierać dalej: ");
                        if (new Scanner(System.in).nextLine().equals("n")) {
                            break;
                        }

                        Student klucz = null;
                        for (Student student2 : student2List) {
                            if (student2.getNrIndeksu() == nrIndeksu) {
                                klucz = student2;
                                break;
                            }
                        }

                        if (klucz == null) {
                            System.out.println("Nie znaleziono studenta");
                        } else {
                            iloscGodzin.putIfAbsent(klucz, 0);
                            System.out.print("Ile godzin opuścił: ");
                            int godzina = new Scanner(System.in).nextInt();
                            iloscGodzin.put(klucz, iloscGodzin.get(klucz) + godzina);
                        }


                        //            student2List.stream()
                        //                    .filter(s -> s.getNrIndeksu() == nrIndeksu)
                        //.forEach(s -> iloscGodzin.put(s, 0));
                    }

                    // wyswietl wszystkich studentow z iloscia godzin.
                    Set<Map.Entry<Student, Integer>> entries = iloscGodzin.entrySet();
                    for (Map.Entry<Student, Integer> entry : entries) {
                        Student student2 = entry.getKey();
                        Integer godzina = entry.getValue();

                        System.out.println(student2.getImie() + " " + student2.getNazwisko());
                        System.out.println(" = " + godzina);
                    }
                }

                public static int pobierzIndeks() {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Nr indeksu studenta: ");
                    return in.nextInt();
                }

                public static Student pobierzStudentow() {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Imie studenta: ");
                    String imie = in.nextLine();

                    System.out.print("Nazwisko studenta: ");
                    String nazwisko = in.nextLine();

                    System.out.print("Numer indeksu studenta: ");
                    Integer nrIndeksu = in.nextInt();

                    return new Student(imie, nazwisko, nrIndeksu);
                }
            }
        }


