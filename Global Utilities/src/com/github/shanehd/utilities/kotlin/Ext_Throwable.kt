package com.github.shanehd.utilities.kotlin

import java.io.StringWriter
import java.io.PrintWriter

/** 
 * @author https://www.github.com/ShaneHD
 */

fun Throwable.stacktraceToString() : String {	
	val sw = StringWriter()
	printStackTrace(PrintWriter(sw))
	return sw.toString()
}