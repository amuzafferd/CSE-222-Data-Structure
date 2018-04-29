import java.util.LinkedList;

public class GTUComEngCoursesPart2<E> extends LinkedList {

    private LinkedList<E> allListElements;
    private LinkedList<E> disableListElements;
    private LinkedList<E> tempList;

    /**
     * @param other
     * @throws Exception
     */
    public GTUComEngCoursesPart2(LinkedList<E> other) throws Exception {
        this.allListElements = other;
        this.tempList = new LinkedList<E>();

        for (int i = 0; i < other.size(); i++) {
            tempList.add(other.get(i));
        }

        this.disableListElements = new LinkedList<E>();
    }

    /**
     * @return
     */
    public LinkedList<E> getAllListElements() {
        return allListElements;
    }

    /**
     * @return
     */
    public LinkedList<E> getDisableListElements() { return disableListElements; }

    /**
     * @param other
     * @throws Exception
     */
    public void printCourses(LinkedList<E> other) throws Exception{

        System.out.println("*********** All Element In List **********");
        for(int i=0; i<other.size(); i++)
            System.out.println(other.get(i).toString());
    }

    /**
     * @param index
     * @return
     * @throws Exception
     */
    public String disable(int index) throws Exception{

        if (index < 0 || index > allListElements.size())
            throw new Exception("The error in disable method. Index is invalid value.");

        disableListElements.add(allListElements.get(index));
        String disableElement = allListElements.get(index).toString();
        allListElements.remove(index);

        return disableElement;
    }

    /**
     * @param index
     * @return
     * @throws Exception
     */
    public String enable(int index) throws Exception{

        if (index < 0 || index > disableListElements.size())
            throw new Exception("The error in enable method. Index is invalid value.");

        allListElements = new LinkedList<E>();
        String enableElement = disableListElements.get(index).toString();
        disableListElements.remove(index);

        for (int i = 0; i < tempList.size() ; i++) {
            if ((!(disableListElements.contains(tempList.get(i)))) && (!(allListElements.contains(tempList.get(i)))))
                allListElements.add(tempList.get(i));
        }

        return enableElement;
    }

    /**
     *
     */
    public void showDisabled(){

        for (int i=0; i<disableListElements.size(); i++)
            System.out.println(disableListElements.get(i).toString());

    }
}
