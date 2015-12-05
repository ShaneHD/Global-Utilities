package com.github.shanehd.utilities.kotlin

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.util.Scanner;

/** 
 * @author https://www.github.com/ShaneHD
 */

fun Scanner.input(vararg message: String) : String {
	if(message.size != 0)
		println(message[0])
	
	return nextLine()
}