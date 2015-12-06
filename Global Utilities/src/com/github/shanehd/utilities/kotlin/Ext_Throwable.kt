package com.github.shanehd.utilities.kotlin

import java.io.StringWriter
import java.io.PrintWriter

fun Throwable.stacktraceToString() : String {	
	val sw = StringWriter()
	printStackTrace(PrintWriter(sw))
	return sw.toString()
}