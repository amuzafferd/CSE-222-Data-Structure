public class Main {

    public static void main(String[] args) {

        MergeSort<Integer> mergeSort = new MergeSort();
        mergeSort.add(10);
        mergeSort.add(15);
        mergeSort.add(3);
        mergeSort.add(4);
        mergeSort.add(35);
        mergeSort.add(5);
        mergeSort.add(19);
        mergeSort.add(1);

        mergeSort.head = mergeSort.mergeSort(mergeSort.head);

        while (mergeSort.head != null){
            System.out.println(mergeSort.head.data);
            mergeSort.head = mergeSort.head.next;
        }
    }
}
