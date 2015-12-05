package ga.shane.utilities;

/** 
 * @author http://www.shane.ga
 */
public interface MapIterator<K, V> {
	void on(K k, V v);
	
	public static interface Reverse<K, V> extends MapIterator<K, V> {
	}
}
