package ga.shane.utilities.kotlin

import ga.shane.utilities.kotlin.*
import java.util.ArrayList
import ga.shane.utilities.StringUtils

/** 
 * @author https://www.github.com/ShaneHD
 */

val Any.quote: String
	get() = "\"$this\""

fun String.splitByLength(maxLength: Int) : ArrayList<String> {
	return StringUtils.splitByLength(this, maxLength)
}

fun String.replaceLast(from: String, to: String) : String {
	return StringUtils.replaceLast(this, from, to)
}

val String.noHTML: String
	get() = StringUtils.cleanHTML(this)

val String.firstUpper: String
	get() = StringUtils.format_FirstLetterUpper(this)
