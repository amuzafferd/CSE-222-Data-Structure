public class MergeSortDoubleLinkedList<E extends Comparable<E>>{

    public Node<E> head;

    public static class Node<E>{

        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public void add(E element) {

        Node<E> node = new Node(element);
        Node<E> end = head;
        node.next = null;

        if(head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while(end.next != null)
            end = end.next;

        end.next = node;
        node.prev = end;
    }

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

    public Node<E> mergeSort(Node<E> other) {
        if (other == null || other.next == null)
            return other;

        Node<E> second = divide(other);

        other = mergeSort(other);
        second = mergeSort(second);

        return merge(other, second);
    }

    private Node<E> merge(Node<E> first, Node<E> second) {

        if (first == null)
            return second;

        if (second == null)
            return first;

        if (first.data.compareTo(second.data) < 0) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }
        else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
}
