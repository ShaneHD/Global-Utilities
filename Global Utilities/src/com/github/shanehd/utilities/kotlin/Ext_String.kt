package com.github.shanehd.utilities.kotlin

import java.util.ArrayList
import com.github.shanehd.utilities.StringUtils
import com.github.shanehd.utilities.FileUtils
import com.github.shanehd.utilities.NewLineIterator

/** 
 * @author https://www.github.com/ShaneHD
 */

/**
 * Surround a {@link String} with quotation marks
 */
val Any.quote: String
	get() = "\"$this\""

/**
 * Split a {@link String} by its {@link String#length()}
 */
fun String.splitByLength(maxLength: Int) : ArrayList<String> {
	return StringUtils.splitByLength(this, maxLength)
}

/**
 * Replace the last occurrence of something in a {@link String}
 */
fun String.replaceLast(from: String, to: String) : String {
	return StringUtils.replaceLast(this, from, to)
}

/**
 * Clean HTML tags from a {@link String}<br>
 * Only replaces < and > for now<br>
 * TODO improve
 */
val String.noHTML: String
	get() = StringUtils.cleanHTML(this)

/**
 * Makes the first character upper case
 */
val String.firstUpper: String
	get() = StringUtils.format_FirstLetterUpper(this)

/**
 * Iterate over all lines (\n)
 */
fun String.iterateLines(iterator: NewLineIterator) {
	FileUtils.iterateLines(this, iterator)
}