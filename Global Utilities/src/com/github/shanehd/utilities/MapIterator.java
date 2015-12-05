package com.github.shanehd.utilities;

/** 
 * @author https://www.github.com/ShaneHD
 */
public interface MapIterator<K, V> {
	void on(K k, V v);
	
	public static interface Reverse<K, V> extends MapIterator<K, V> {
	}
}
