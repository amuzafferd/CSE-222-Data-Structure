import java.util.LinkedList;


public class RecursiveHashingSet<K,V> {

    private LinkedList<Entry <K,V> > [] table;
    private int numKeys;


    private static class Entry < K, V > {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    public RecursiveHashingSet() {
        table = new LinkedList[10];
    }

}
