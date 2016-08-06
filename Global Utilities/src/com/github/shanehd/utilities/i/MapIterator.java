package com.github.shanehd.utilities.i;

/** 
 * @author https://www.github.com/ShaneHD
 */
public interface MapIterator<K, V> {
	void on(K k, V v);
	
	interface Reverse<K, V> extends MapIterator<K, V> {
	}
}
