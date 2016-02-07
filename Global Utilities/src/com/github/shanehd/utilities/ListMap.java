package com.github.shanehd.utilities;

        import java.util.ArrayList;
        import java.util.LinkedHashMap;
        import java.util.Map;

/**
 * @author https://www.github.com/ShaneHD
 */
public class ListMap<K, V> extends LinkedHashMap<K, ArrayList<V>> {
    public ListMap() {
        super();
    }

    public ListMap(int initialCapacity) {
        super(initialCapacity);
    }

    public ListMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public ListMap(Map<? extends K, ?extends ArrayList<V>> m) {
        super(m);
    }

    public boolean remove(Object key, Object value) {
        ArrayList<V> values = get(key);
        boolean contains = values.contains(value);

        if(contains)
            values.remove(value);

        if(values.isEmpty())
            super.remove(key);

        return contains;
    }

    public ListMap<K, V> add(K key, V value) {
        if(containsKey(key))
            get(key).add(value);
        else {
            put(key, new ArrayList<V>());
            return add(key, value);
        }

        return this;
    }

    public ArrayList<V> list(@SuppressWarnings("unchecked") K... keys) {
        ArrayList<V> values = new ArrayList<V>();

        if(keys.length == 0) {
            for(ArrayList<V> value : values())
                values.addAll(value);
        } else {
            for(K key : keys)
                values.addAll(get(key));
        }

        return values;
    }
}