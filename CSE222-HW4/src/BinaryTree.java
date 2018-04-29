public class BinaryTree<E extends Comparable<E>> {

    /**
     * Node class
     */
    protected static class Node<E>
    {
        protected E data;
        public Node<E> left;
        public Node<E> right;

        public Node(E data)
        {
            this.data = data;
            left = null;
            right = null;
        }

        public String toString() { return data.toString(); }
    }

    /**
     * variables
     */
    protected Node<E> root;
    protected Node<E> findNode;
    protected E tempItem;
    protected int tempInt;

    /**
     * no parameter constructor
     */
    public BinaryTree() {
        root = null;
        findNode = new Node<E>(null);
    }

    /**
     * @param parentItem
     * @param childItem
     * @return
     */
    public boolean add(E parentItem, E childItem) {
        if (root == null) {
            root = new Node<E>(parentItem);
            root.left = new Node<E>(childItem);
            return true;
        } else {
            postOrderSearch(parentItem);
            if(findNode == null){
                return false;
            }
            else {
                if(findNode.left == null){
                    findNode.left = new Node<E>(childItem);
                    return true;
                }
                else {
                    Node<E> temp = findNode.left;
                    while (temp.right != null)
                        temp = temp.right;

                    temp.right = new Node<E>(childItem);
                    return true;
                }
            }
        }
    }

    /**
     * @param item
     * @return
     */
    public E postOrderSearch(E item){

        System.out.println("Searched value: " + item);
        System.out.print("Viseted nodes: ");
        tempInt = 0;
        tempItem = null;
        postOrderSearchHelper(root, item);
        System.out.println("\nSearch result: " + tempItem + "\n");
        return tempItem;
    }

    /**
     * @param node
     * @param item
     */
    private void postOrderSearchHelper(Node<E> node, E item){

        if(node != null && tempInt == 0){
            postOrderSearchHelper(node.left, item);
            if(tempInt == 0){
                System.out.print(node.data + "  ");

                if(node.data.compareTo(item) == 0) {
                    findNode = node;
                    tempItem = node.data;
                    tempInt++;
                }
            }
            postOrderSearchHelper(node.right, item);
        }
    }

    /**
     * @param item
     * @return
     */
    public E levelOrderSearch(E item){

        System.out.println("Searched value: " + item);
        System.out.print("Viseted nodes: ");
        tempInt = 0;
        tempItem = null;
        levelOrderSearchHelper(root, item);
        System.out.println("\nSearch result: " + tempItem + "\n");
        return tempItem;
    }

    /**
     * @param node
     * @param item
     */
    private void levelOrderSearchHelper(Node<E> node, E item){

        if(node != null && tempInt == 0){
            System.out.print(node.data + "  ");

            if (node.data.compareTo(item) == 0){
                findNode = node;
                tempItem = node.data;
                tempInt++;
            }
            else {
                if (node.right != null)
                    levelOrderSearchHelper(node.right, item);
                if (node.left != null)
                    levelOrderSearchHelper(node.left, item);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * ekrana basma fonksiyonu
     * @param node ekrana basılacak tree
     * @param depth
     * @param sb
     */
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {

        for (int i = 1; i < depth; i++)
            sb.append("  ");

        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");

            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth, sb);
        }
    }
}