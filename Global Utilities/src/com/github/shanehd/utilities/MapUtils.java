package com.github.shanehd.utilities;

import com.github.shanehd.utilities.i.MapIterator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link Map} utilities
 *
 * @author https://www.github.com/ShaneHD
 */
public class MapUtils {
	/**
	 * Reverse a {@link Map}'s order
	 */
	public static <K, V> LinkedHashMap<K, V> reverse(Map<K, V> map) {
		ArrayList<K> keys = new ArrayList<K>(map.keySet());
		LinkedHashMap<K, V> reversed = new LinkedHashMap<K, V>();
		
		for(int i = keys.size() - 1; i >= 0; i--) {
			K key = keys.get(i);
			reversed.put(key, map.get(key));
		}
		
		return reversed;
	}

	/**
	 * Iterate over a {@link Map} using {@link MapIterator}
	 */
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

	/**
	 * Get a {@link Map}s keys and values into a readable {@link String}<br/>
	 * Uses format: <code>key=value\n</code>
	 * @param map
	 * @return
	 */
	public static String toString(Map<?,?> map) {
		final StringBuilder list = new StringBuilder();

		iterate(map, (o, o2) -> {
			list.append(o + "=" + o2);
        });

		return list.toString();
	}
}
