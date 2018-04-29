import java.util.Random;

public class Main {

    /**
     * Parametre olarak gelen array'i dolduran metot
     * @param other array
     */
    public static void generateNumber(Integer[] other){

        for (int i = other.length - 1, j=0; i > -1; i--, j++) {
            other[j] = i;
        }
    }

    public static void main(String[] args) {

        int sizeOfArray = 100;

        Integer [] intArray = new Integer[sizeOfArray];
        Integer [] tempArray = new Integer[sizeOfArray];

        generateNumber(intArray);

        System.arraycopy(intArray, 0 , tempArray, 0, sizeOfArray);
        InsertionSort insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(tempArray);
        long timeOfInsertionSort = (System.nanoTime() - startTime);

        System.arraycopy(intArray, 0 , tempArray, 0, sizeOfArray);
        QuickSort quickSort = new QuickSort();
        startTime = System.nanoTime();
        quickSort.sort(tempArray);
        long timeOfQuickSort = (System.nanoTime() - startTime);

        System.arraycopy(intArray, 0 , tempArray, 0, sizeOfArray);
        HeapSort heapSort = new HeapSort();
        startTime = System.nanoTime();
        heapSort.sort(tempArray);
        long timeOfHeapSort = (System.nanoTime() - startTime);

        System.arraycopy(intArray, 0 , tempArray, 0, sizeOfArray);
        MergeSort mergeSort = new MergeSort();
        startTime = System.nanoTime();
        mergeSort.sort(tempArray);
        long timeOfMergeSort = (System.nanoTime() - startTime);

        MergeSortDoubleLinkedList mergeSortDLL = new MergeSortDoubleLinkedList();
        for (int j = 0; j < sizeOfArray; j++)
            mergeSortDLL.add(intArray[j]);

        startTime = System.nanoTime();
        mergeSortDLL.head = mergeSortDLL.mergeSort(mergeSortDLL.head);
        long timeOfMergeSortDLL = (System.nanoTime() - startTime);


        System.out.println("Worst case of insertion sort \t: " + timeOfInsertionSort);
        System.out.println("Worst case of quick sort \t\t: " + timeOfQuickSort);
        System.out.println("Worst case of heap sort \t\t: " + timeOfHeapSort);
        System.out.println("Worst case of merge sort \t\t: " + timeOfMergeSort);
        System.out.println("Worst case of merge sort dll \t: " + timeOfMergeSortDLL);
    }
}
