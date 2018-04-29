import java.util.*;

public class DoubleHashingMap<K,V> implements Map<K,V> {

    /**
     * Inner class
     * @param <K>
     * @param <V>
     */
    private static class Entry < K, V > {


        private K key;
        private V value;

        /**
         * Entry constructor
         * @param key
         * @param value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Get key
         * @return key
         */
        public K getKey() {
            return key;
        }

        /**
         * Get value
         * @return value
         */
        public V getValue() {
            return value;
        }

        /**
         * Set value
         * @param val
         * @return oldValue
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    Entry<K, V> [] table;
    int numKeys;

    /**
     * DoubleHashingMap constructor
     */
    public DoubleHashingMap(){
        table = new Entry[10];
    }

    /**
     * Size metodu
     * @return numKeys
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * Array'in boş olup olmamasını kontrol ediyor
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /**
     * Ekleme metodu, ekleme başarılı ise eklenen değeri return eder.
     * @param key
     * @param value
     * @return value
     */
    @Override
    public V put(K key, V value) {

        int hashValue = key.hashCode() % table.length;
        int step = 7 - (key.hashCode() % 7);

        if(numKeys >= table.length)
            resize();

        if(table[hashValue] == null) {
            table[hashValue] = new Entry<K, V>(key, value);
            numKeys++;
        }
        else{
            while (table[hashValue] != null){
                hashValue += step;
                if(hashValue >= table.length)
                    hashValue %= table.length;
            }

            table[hashValue] = new Entry<K, V>(key, value);
            numKeys++;
        }

        return value;
    }

    /**
     * Array boyutu aşıldıysa boyut arttırılır.
     */
    private void resize() {

        Entry<K,V> [] temp = table;
        table = new Entry[table.length * 2];
        System.arraycopy(temp, 0 , table, 0, temp.length);
    }

    /**
     * Tabloyu ekrana basar
     */
    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < table.length; j++) {
            if (table[j] != null)
                System.out.println(j + " --> " + table[j].getValue() + " ");
            else
                System.out.println(j + " --> " + "** ");
        }
        System.out.println("");
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V remove(Object key) {
        return null;
    }

    /**
     *
     * @param m
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {}

    /**
     *
     */
    @Override
    public void clear() { }

    /**
     *
     * @return
     */
    @Override
    public Set<K> keySet() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<V> values() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    /**
     *
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get(Object key) {
        return null;
    }

}
