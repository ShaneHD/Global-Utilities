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
}
