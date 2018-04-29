import java.util.Random;

public class Main {

    /**
     * Parametre olarak gelen array'i dolduran metot
     * @param other array
     */
    public static void generateRandomNumber(Integer[] other){

        Random r = new Random();
        for (int i = 0; i < other.length; i++) {
            other[i] = r.nextInt(100);
        }
    }

    public static void main(String[] args) {

        int sizeOfArray = 4096;
        int repeatNumber = 10;
        long timeOfInsertionSort = 0;
        long timeOfQuickSort = 0;
        long timeOfHeapSort = 0;
        long timeOfMergeSort = 0;
        long timeOfMergeSortDLL = 0;

        Integer [] intArray = new Integer[sizeOfArray];
        Integer [] tempArray = new Integer[sizeOfArray];

        for (int i = 0; i < repeatNumber; i++) {
            generateRandomNumber(intArray);

            System.arraycopy(intArray, 0 , tempArray, 0, sizeOfArray);
            InsertionSort insertionSort = new InsertionSort();
            long startTime = System.nanoTime();
            insertionSort.sort(tempArray);
            timeOfInsertionSort += (System.nanoTime() - startTime);

            System.arraycopy(intArray, 0 , tempArray, 0, sizeOfArray);
            QuickSort quickSort = new QuickSort();
            startTime = System.nanoTime();
            quickSort.sort(tempArray);
            timeOfQuickSort += (System.nanoTime() - startTime);

            System.arraycopy(intArray, 0 , tempArray, 0, sizeOfArray);
            HeapSort heapSort = new HeapSort();
            startTime = System.nanoTime();
            heapSort.sort(tempArray);
            timeOfHeapSort += (System.nanoTime() - startTime);

            System.arraycopy(intArray, 0 , tempArray, 0, sizeOfArray);
            MergeSort mergeSort = new MergeSort();
            startTime = System.nanoTime();
            mergeSort.sort(tempArray);
            timeOfMergeSort += (System.nanoTime() - startTime);

            MergeSortDoubleLinkedList mergeSortDLL = new MergeSortDoubleLinkedList();
            for (int j = 0; j < sizeOfArray; j++)
                mergeSortDLL.add(intArray[j]);

            startTime = System.nanoTime();
            mergeSortDLL.head = mergeSortDLL.mergeSort(mergeSortDLL.head);
            timeOfMergeSortDLL += (System.nanoTime() - startTime);
        }

        System.out.println("Avarage time of insertion sort \t: " + timeOfInsertionSort / repeatNumber);
        System.out.println("Avarage time of quick sort \t\t: " + timeOfQuickSort / repeatNumber);
        System.out.println("Avarage time of heap sort \t\t: " + timeOfHeapSort / repeatNumber);
        System.out.println("Avarage time of merge sort \t\t: " + timeOfMergeSort / repeatNumber);
        System.out.println("Avarage time of merge sort dll \t: " + timeOfMergeSortDLL / repeatNumber);

    }
}
