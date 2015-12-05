package ga.shane.utilities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/** 
 * @author http://www.shane.ga
 */
public class MapUtils {
	public static <K, V> Map<K, V> reverse(Map<K, V> map) {
		ArrayList<K> keys = new ArrayList<K>(map.keySet());
		LinkedHashMap<K, V> reversed = new LinkedHashMap<K, V>();
		
		for(int i = keys.size() - 1; i >= 0; i--) {
			K key = keys.get(i);
			reversed.put(key, map.get(key));
		}
		
		return reversed;
	}
	
	public static <K, V> void iterate(Map<K, V> map, MapIterator<K, V> iterator) {
		if(iterator instanceof MapIterator.Reverse) {
			doIterate(reverse(map), iterator);
			return;
		}
		
		doIterate(map, iterator);
	}
	
	private static <K, V> void doIterate(Map<K, V> map, MapIterator<K, V> iterator) {
		for(Map.Entry<K, V> e : map.entrySet()) {
			iterator.on(e.getKey(), e.getValue());
		}
	}
}
