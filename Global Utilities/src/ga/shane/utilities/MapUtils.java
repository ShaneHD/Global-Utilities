package ga.shane.utilities;

import java.util.Map;

/** 
 * @author http://www.shane.ga
 */
public class MapUtils {
	public static <K, V> void iterate(Map<K, V> map, MapIterator<K, V> iterator) {
		for(Map.Entry<K, V> e : map.entrySet()) {
			iterator.on(e.getKey(), e.getValue());
		}
	}
}
