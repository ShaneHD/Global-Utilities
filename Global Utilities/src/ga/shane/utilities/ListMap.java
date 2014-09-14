package ga.shane.utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A {@link HashMap} containing<br>
 * <i>{@literal <K, ArrayList<V>>}</i>
 * 
 * @see {@link HashMap}
 * @author http://www.shane.ga
 */
public class ListMap<K, V> extends HashMap<K, ArrayList<V>> {
	public ListMap() {
		super();
	}
	
	public ListMap(int initialCapacity) {
		super(initialCapacity);
	}
	
	public ListMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}
	
	public ListMap(Map<?extends K, ?extends ArrayList<V>> m) {
		super(m);
	}
	
	@Override
	public ArrayList<V> put(K key, ArrayList<V> value) {
		return super.put(key, value);
	}
	
	/**
	 * <b><font color='green'>USE THIS</font></b>
	 */
	@SuppressWarnings("rawtypes")
	public ListMap put(K key, V value) {
		if(containsKey(key))
			get(key).add(value);
		else {
			put(key, new ArrayList<V>());
			put(key, value);
		}
		
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<V> list(K... key) {
		if(key.length == 0) {
			ArrayList<V> values = new ArrayList<V>();
			
			for(ArrayList<V> value : values())
				values.addAll(value);
			
			return values;
		} else
			return get(key[0]);
	}
}
