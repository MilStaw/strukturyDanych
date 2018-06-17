package zadanie3;

    class MyArrayList {                                ///  tutaj bedzie zmiana

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

        public void remove(MyArrayList otherList) {   /// kawalek do zadania  2
            for (int i=0; i<otherList.size() -1; i++) {
                Integer actualElement = otherList.get(i);
                remove(actualElement);
            }
        }
        public MyArrayList diff(MyArrayList otherList) {   /// kawalek do zadania  3
            MyArrayList different = new MyArrayList();

            /*for ( int i = 0; i < size(); i++ ){                 zwraca wspolne elementy
              for (int j = 0; j < otherList.size() - 1; j++) {
                  if (get(i).equals(otherList.get(j))) {
                      different.add(get(i));
                  }
              }
                //int x = otherList.get(i);
                */

           /* for (int i = 0; i < this.size() - 1; i++) {         ///zwraca elementy w pierwszej liscie inne niz w drugiej
                boolean isExistInOthers = false;
                for (int j = 0; j < otherList.size() - 1; j++) {
                    if (this.get(i).equals(otherList.get(j))) {
                        isExistInOthers = true;
                        break;
                    }
                }

                if (!isExistInOthers) {
                    different.add(get(i));
                }*/

            for (int i = 0; i < otherList.size() - 1; i++) {                ///zwraca elementy w drugiej liscie inne niz w pierwszej
                boolean isExistInOthers = false;
                for (int j = 0; j < this.size() - 1; j++) {
                    if (otherList.get(i).equals(this.get(j))) {
                        isExistInOthers = true;
                        break;
                    }
                }

                if (!isExistInOthers) {
                    different.add(otherList.get(i));
                }
            }


            return different;
        }

        public int size(){
                return index + 1;
        }
    }

 public class Zadanie3 {

     public static void main(String[] args) {
         MyArrayList words = new MyArrayList();
         words.add(4);
         words.add(3);
         words.add(5);
         words.add(10);
         words.add(4);
         words.add(7);
         words.add(8);
         words.add(4);

         MyArrayList otherList = new MyArrayList();   ///odtad
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
         System.out.println("Dif: ");
         otherList = new MyArrayList();
         otherList.add(1);
         otherList.add(2);
         otherList.add(4);

         MyArrayList diff = words.diff(otherList);
         for (int i = 0; i < diff.size() - 1; i++) {
             System.out.println(diff.get(i));
         }
     }
 }


