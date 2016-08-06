package com.github.shanehd.utilities.kotlin

import java.util.*

/** 
 * @author https://www.github.com/ShaneHD
 */

fun Scanner.input(vararg message: String) : String {
	if(message.size != 0)
		println(message[0])
	
	return nextLine()
}