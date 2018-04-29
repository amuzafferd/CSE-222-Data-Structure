public class Main {

    public static void main(String[] args) {
        BTree bTree = new BTree(3);

        bTree.add(10);
        bTree.add(14);
        bTree.add(11);
        bTree.add(22);
        bTree.add(65);
        bTree.add(3);
        bTree.add(1);
        bTree.add(56);
        bTree.add(16);
        bTree.add(43);
        bTree.add(6);
        bTree.add(14);
        bTree.add(14);

        System.out.print(bTree.toString());


    }
}
