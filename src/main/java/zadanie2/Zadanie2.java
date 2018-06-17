package zadanie2;


import static sun.plugin2.os.windows.OSVERSIONINFOA.size;

class MyArrayList {
    ////remove iteracyjny    (w petli jest zawsze)     a rekurencyjny jest bez petli
        ////w LinkedLIST mamy tyle pudelek ile elementow    w niej usuwanie jest wolniejsze

        private static final int CAPACITY = 10000;
        private Integer[] numbers = new Integer[CAPACITY];
        private int index = 0;

        public Integer get(Integer i) {
            return numbers[i];
        }

        public void add(Integer number) {
            if (index >= numbers.length) {
                copy(2 * numbers.length);
            }
            numbers[index++] = number;
        }

        public void remove(Integer x) {
            for (int i = 0; i < size() - 1; i++) {
                if (x.equals(get(i))) {
                    numbers[i] = null;
                }
            }

            copy(size());
        }

        private void copy(int newSize) {
            Integer[] temp = new Integer[newSize];
            int tabSize = size();
            int tempIndex = 0;

            for (int i = 0; i < tabSize - 1; i++) {
                if (get(i) != null) {
                    temp[tempIndex++] = get(i);
                }
            }
            index = tempIndex;
            numbers = temp;
        }

        public void remove(zadanie2.MyArrayList otherList) {   /// kawalek do zadania  2
            for (int i = 0; i < otherList.size() - 1; i++) {
                Integer actualElement = otherList.get(i);
                remove(actualElement);

            }
        }


        public int size() {
             return index + 1;
        }
    }


    public class Zadanie2 {

        public void main(String[] args) {
            zadanie2.MyArrayList words = new zadanie2.MyArrayList();
            words.add(4);
            words.add(3);
            words.add(5);
            words.add(10);
            words.add(4);
            words.add(7);
            words.add(8);
            words.add(4);

            zadanie2.MyArrayList otherList = new zadanie2.MyArrayList();   ///odtad
            otherList.add(4);
            otherList.add(10);
            otherList.add(101);


            System.out.println("init: ");
            for (int i = 0; i < words.size() - 1; i++) {
                System.out.print(words.get(i) + ", ");
            }

            //words.remove(4);
            words.remove(otherList);                     ////dotad jest do zadania 2

            System.out.println();
            System.out.println("After remove `4`: ");
            for (int i = 0; i < words.size() - 1; i++) {
                System.out.print(words.get(i) + ", ");
            }
        }
    }


