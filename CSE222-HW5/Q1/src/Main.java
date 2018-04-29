public class Main {

    public static void main(String[] args) {

        DoubleHashingMap<Integer, Integer> myHashTable = new DoubleHashingMap<>();

        myHashTable.put(0,1);
        myHashTable.put(0,2);
        myHashTable.put(0,3);
        myHashTable.put(0,4);
        myHashTable.put(0,5);
        myHashTable.put(0,6);
        myHashTable.put(0,7);
        myHashTable.put(0,8);
        myHashTable.put(0,9);
        myHashTable.put(0,10);
        myHashTable.put(0,11);

        myHashTable.displayTable();
        System.out.println("Size: " + myHashTable.size());
        System.out.println("isEmpty: " + myHashTable.isEmpty());


        DoubleHashingMap<Integer, Integer> myHashTable2 = new DoubleHashingMap<>();

        myHashTable2.put(0,1);
        myHashTable2.put(1,2);
        myHashTable2.put(3,3);
        myHashTable2.put(5,4);
        myHashTable2.put(5,5);
        myHashTable2.put(2,6);

        System.out.println();
        myHashTable2.displayTable();
        System.out.println("Size: " + myHashTable2.size());
        System.out.println("isEmpty: " + myHashTable2.isEmpty());

    }
}
