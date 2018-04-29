public class GTUComEngCoursesPart3<E> {

    public class Node<E>
    {
        private E data;
        private Node<E> next;

        /**
         *
         */
        public Node()
        {
            this.data = null;
            this.next = null;
        }

        /**
         * @param dataItem
         */
        public Node(E dataItem)
        {
            this.data = dataItem;
            this.next = null;
        }

        /**
         * @param dataItem
         * @param nodeRef
         */
        public Node(E dataItem, Node<E> nodeRef)
        {
            this.data = dataItem;
            this.next = nodeRef;
        }

        /**
         * @return
         */
        public Node<E> getNext() { return next; }

        /**
         * @return
         */
        public E getData() { return data; }

        /**
         * @param other
         */
        public void setNext(Node<E> other) { this.next = other; }

        /**
         * @param other
         */
        public void setData(E other) { this.data = other; }
    }

    private Node<E> head;
    private Node<E> current;
    private Node<E> semesterCurrent;
    private int size;

    /**
     * @return
     */
    public Node getHead() { return head; }

    /**
     * @return
     */
    public int getSize() { return size; }

    /**
     * @param head
     */
    public void setHead(Node head) { this.head = head; }

    /**
     * @param size
     */
    public void setSize(int size) { this.size = size; }

    /**
     *
     */
    public GTUComEngCoursesPart3()
    {
        head = null;
        current = new Node<E>();
        semesterCurrent = null;
        size = 0;
    }

    /**
     * @param data
     */
    public void add(Object data)
    {
        Node temp = new Node(data);
        Node curr = head;

        if (head == null)
        {
            head = temp;
            ++size;
            current.next = head;
        }
        else
        {
            while (curr.getNext() != null)
                curr = curr.getNext();

            curr.setNext(temp);
            ++size;
        }
    }

    /**
     * @return
     */
    public boolean hasNext(){
        return (current.getNext() != null);
    }

    public E next(){

        current = current.next;
        return current.data;
    }

    /**
     * @return
     */
    public E nextInSemester(){

        if(current.data == null)
            semesterCurrent = current.next;
        else
            semesterCurrent = current;

        String firstSemester = ((GTUComEngCourses) semesterCurrent.getData()).getSemester();
        while (semesterCurrent.getNext() != null){
            semesterCurrent = semesterCurrent.next;
            if(firstSemester.equals(((GTUComEngCourses) semesterCurrent.getData()).getSemester())) {
                current = semesterCurrent;
                return current.getData();
            }
        }

        Node temp = head;
        while(temp.getNext() != null){
            if(((GTUComEngCourses) temp.getData()).getSemester().equals(firstSemester)){
                current = temp;
                break;
            }
            temp = temp.next;
        }

        return current.getData();
    }

    /**
     * @param index
     * @return
     */
    public Object get(int index)
    {
        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.getNext();

        return curr.getData();
    }

    /**
     * @param index
     */
    public void remove(int index)
    {
        Node curr = head;

        if (index == 0) {
            current = head;
            head = head.next;
        } else {
            for (int i = 1; i < index; i++)
                curr = curr.next;

            curr.next = curr.next.next;
        }

        this.size--;
    }

    /**
     * @return
     */
    public int size() { return this.size; }

    /**
     *
     */
    public void resetCurrent(){
        current = new Node<E>();
        current.next = head;
    }
}
