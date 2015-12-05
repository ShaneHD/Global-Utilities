package ga.shane.utilities.kotlin

import java.io.File
import ga.shane.utilities.kotlin.*

/** 
 * @author http://www.shane.ga
 */

val File.newlyCreated: Boolean 
	get() = CACHE.contains(this)

fun File.makeNewFile() : Boolean {
	CACHE.add(this)
	return true
}