package zadanie6a;


    class MyArrayList {                                               ///metoda z contains   kolejny podpunkt w zadaniu 6
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

        public void remove(MyArrayList otherList) {
            for (int i = 0; i < otherList.size() - 1; i++) {
                Integer actualElement = otherList.get(i);
                remove(actualElement);
            }

            copy(size());
        }

        public boolean contains(Integer x) {
            for (int i = 0; i < size() - 1; i++) {
                Integer actualElement = get(i);
                if (actualElement.equals(x)) {
                    return true;
                }
            }
            return false;
        }

        public boolean contains(MyArrayList otherList) {
            boolean isExist = false;
            for (int i = 0; i < otherList.size(); i++) {
                if (contains(otherList.get(i))) {
                    isExist = true;
                }
            }

            return isExist;
        }

        public MyArrayList diff(MyArrayList otherList) {
            MyArrayList different = new MyArrayList();

            for (int i = 0; i < this.size() - 1; i++) {
                boolean isExistInOthers = false;
                for (int j = 0; j < otherList.size() - 1; j++) {
                    if (this.get(i).equals(otherList.get(j))) {
                        isExistInOthers = true;
                        break;
                    }
                }

                if (!isExistInOthers) {
                    different.add(get(i));
                }
            }

            for (int i = 0; i < otherList.size() - 1; i++) {
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

        private void removeRecur(Integer x, int i) {
            if (i < 0) {
                return;
            }
            if (x.equals(get(i))) {
                numbers[i] = null;
            }
            removeRecur(x, i - 1);
        }

        public void removeRecurWithCopy(Integer x) {
            removeRecur(x, index);
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

        public int size() {
            return index + 1;
        }
    }

    class Main {

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

            System.out.println("init: ");
            for (int i = 0; i < words.size() - 1; i++) {
                System.out.print(words.get(i) + ", ");
            }

            words.removeRecurWithCopy(4);

            System.out.println();
            System.out.println("After remove `4`: ");
            for (int i = 0; i < words.size() - 1; i++) {
                System.out.print(words.get(i) + ", ");
            }

            System.out.println("Diff: ");
            MyArrayList otherList = new MyArrayList();
            otherList.add(1);
            otherList.add(2);
            otherList.add(4);
            otherList.add(10);

            MyArrayList diff = words.diff(otherList);
            for (int i = 0; i < diff.size() - 1; i++) {
                System.out.println("diff: " + diff.get(i));
            }

            MyArrayList ct = new MyArrayList();
            ct.add(99);
            System.out.println("contains: " + words.contains(ct));
        }
    }

