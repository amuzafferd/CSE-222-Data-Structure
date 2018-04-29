public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> myBinaryTree = new BinaryTree<>();

        myBinaryTree.add(1,2);
        myBinaryTree.add(1,4);
        myBinaryTree.add(1,7);
        myBinaryTree.add(2,3);
        myBinaryTree.add(2,6);
        myBinaryTree.add(3,5);


        System.out.println("---------------------------------------------------------------------");
        System.out.println("----------- TEST OF TOSTRING METHOD WITH PREORDERTRAVERSE -----------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println(myBinaryTree.toString());


        System.out.println("------------------------------------------------------");
        System.out.println("----------- TEST OF POSTORDERSEARCH METHOD -----------");
        System.out.println("------------------------------------------------------");
        myBinaryTree.postOrderSearch(1);
        myBinaryTree.postOrderSearch(2);
        myBinaryTree.postOrderSearch(3);
        myBinaryTree.postOrderSearch(4);
        myBinaryTree.postOrderSearch(5);
        myBinaryTree.postOrderSearch(6);
        myBinaryTree.postOrderSearch(7);
        myBinaryTree.postOrderSearch(8);


        System.out.println("-------------------------------------------------------");
        System.out.println("----------- TEST OF LEVELORDERSEARCH METHOD -----------");
        System.out.println("-------------------------------------------------------");
        myBinaryTree.levelOrderSearch(1);
        myBinaryTree.levelOrderSearch(2);
        myBinaryTree.levelOrderSearch(3);
        myBinaryTree.levelOrderSearch(4);
        myBinaryTree.levelOrderSearch(5);
        myBinaryTree.levelOrderSearch(6);
        myBinaryTree.levelOrderSearch(7);
        myBinaryTree.levelOrderSearch(8);

    }
}