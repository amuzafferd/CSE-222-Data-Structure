public class MergeSort<E extends Comparable<E>>{

    public Node<E> head;

    /**
     * Inner Class
     */
    public static class Node<E>{

        E data;
        Node<E> next;
        Node<E> prev;

        /**
         * Node constructor
         * @param data E tipinde
         */
        Node(E data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    /**
     * Parametre olarak gelen elamanı listeye ekler.
     * @param element E tipinde
     */
    public void add(E element) {

        Node<E> node = new Node(element);
        Node<E> tail = head;
        node.next = null;

        if(head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while(tail.next != null)
            tail = tail.next;

        tail.next = node;
        node.prev = tail;
    }

    /**
     * Recursive merge sort metodu
     * @param other Node
     * @return Node
     */
    public Node<E> mergeSort(Node<E> other) {
        if (other == null || other.next == null)
            return other;

        Node<E> second = divide(other);

        other = mergeSort(other);
        second = mergeSort(second);

        return mergeSortCompare(other, second);
    }

    /**
     * Parametre olarak gelen Node'u bölmek için kullanılan metot
     * @param other Node
     * @return Node
     */
    private Node<E> divide(Node<E> other) {
        Node<E> first = other;
        Node<E> second = other;

        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }
        Node<E> temp = second.next;
        second.next = null;
        return temp;
    }

    /**
     * Karşılaştırma yapan metot.
     * @param first Node
     * @param second Node
     * @return Node
     */
    private Node<E> mergeSortCompare(Node<E> first, Node<E> second) {

        if (first == null)
            return second;

        if (second == null)
            return first;

        if (first.data.compareTo(second.data) < 0) {
            first.next = mergeSortCompare(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }
        else {
            second.next = mergeSortCompare(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
}
