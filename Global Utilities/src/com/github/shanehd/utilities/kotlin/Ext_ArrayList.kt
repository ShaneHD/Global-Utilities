package com.github.shanehd.utilities.kotlin

import java.util.ArrayList

/** 
 * @author https://www.github.com/ShaneHD
 */

/**
 * Adds ONLY if the list doesn't contain it
*/
fun ArrayList<Any>.addIfNotContains(thing: Any) {
	if(!contains(thing))
		add(thing)
}