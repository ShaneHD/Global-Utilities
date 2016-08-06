package com.github.shanehd.utilities.kotlin

import java.io.File
import com.github.shanehd.utilities.kotlin.addIfNotContains
import com.github.shanehd.utilities.FileUtils
import com.github.shanehd.utilities.i.NewLineIterator
import java.util.HashMap
import java.util.ArrayList


/** 
 * @author https://www.github.com/ShaneHD
 */

/**
 * @return Has this {@link File} been created in this session?<br>
 * (has {@link #createNewFile()} been called)
 */
val File.isNewlyCreated: Boolean 
	get() = CACHE.contains(this)

fun File.makeNewFile(): Boolean {
	CACHE.addIfNotContains(this)
	return createNewFile()
}

/**
 * Check if a {@link File} is an image or not
 */
fun File.isImage() : Boolean {
	return FileUtils.isImage(this)
}

fun File.iterateLines(iterator: NewLineIterator) {
	FileUtils.iterateLines(this, iterator)
}

fun File.toByteArray() : ByteArray {
	return FileUtils.fileToByteArray(this)
}

/**
 * Gets the file's parent directory
 */
fun File.getParentDirectory() : File {
	return FileUtils.getParentDirectory(this)
}

/**
 * Get a value from a file using {@link #separator} to separate the key and value
 */
fun File.getValue(key: String) : String {
	return FileUtils.getValue(key, this)
}

/**
 * Load a configuration file into a {@link HashMap}
 */
fun File.toHashMap() : HashMap<String, String> {
	return FileUtils.loadFileIntoHashMap(this)
}

/**
 * Bundle all of a file's lines into a {@link ArrayList}
 */
fun File.getLines() : ArrayList<String> {
	return FileUtils.getFileLines(this)
}

/**
 * Get the contents of a file into a single {@link String}<br>
 * uses '\n' char for new lines
 */
fun File.getContents() : String {
	return FileUtils.getFileContents(this)
}

/**
 * Uses UTF-16 encoding
 * @see #getFileContents(File)
 * @author Someone from stackoverflow. Don't have their name.
 */
fun File.getContentsUTF16() : String {
	return FileUtils.getFileContentsUTF16(this)
}

/**
 * Write something to a file
 * @return Whether the write was successful or not
 */
fun File.write(thing: Any, vararg append: Boolean) : Boolean {
	throw RuntimeException("FIX THIS TODO")
	//	if(append.isEmpty())
//		return FileUtils.write(thing, this)
//
//	return FileUtils.write(thing, this, true)
} 