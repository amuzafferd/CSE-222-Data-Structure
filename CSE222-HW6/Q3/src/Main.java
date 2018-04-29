public class Main {

    public static void main(String[] args) {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.add(2);
        binarySearchTree.add(1);
        binarySearchTree.add(3);
        binarySearchTree.add(4);

        AVLTree avlTree = new AVLTree(binarySearchTree);

    }
}
