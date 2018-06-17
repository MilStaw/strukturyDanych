package zadanie6;

class Node {
    public Integer element;
    public Node next;

    public Node(Integer e) {

        element = e;
    }
}

class MyLinkedList {
    private Node firstElement;
    private int index = 0;

    public int get(int i) throws Exception {
        Node n = firstElement;
        for (int j = 0; i != j && n != null; j++) {
            n = n.next;
        }

        if (n == null) {
            throw new Exception("Brak elementów");
        }

        return n.element;
    }

    public void add(Integer x) {
        System.out.println("Początek");
        if (firstElement == null){
            System.out.println("Pierwszy element");
            firstElement = new Node(x);
            System.out.println(firstElement.element);
        } else {
            Node n = firstElement;
            for (; n.next != null; ) {
                System.out.println("For: " + n.element);
                n = n.next;
            }

            System.out.println("Last.e: " + n.element);
            System.out.println("Last.n: " + n.next);
            n.next = new Node(x);
            System.out.println("Last.n2: " + n.next);
            System.out.println("Last.e: " + n.next.element);
        }
    }
}

public class Zadanie6 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(5);
        myLinkedList.add(2);
        //myLinkedList.add(3);
    }
}
