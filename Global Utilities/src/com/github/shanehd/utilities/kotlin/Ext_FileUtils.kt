package ga.shane.utilities.kotlin

import java.io.File

/** 
 * @author https://www.github.com/ShaneHD
 */

val File.newlyCreated: Boolean 
	get() = CACHE.contains(this)

fun File.makeNewFile(): Boolean {
	CACHE.add(this)
	return true
}
