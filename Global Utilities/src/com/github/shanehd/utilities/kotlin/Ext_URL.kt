package com.github.shanehd.utilities.kotlin

import java.net.URL
import com.github.shanehd.utilities.FileUtils

/** 
 * @author https://www.github.com/ShaneHD
 */

/**
 * Downloads a file and saves it to a location on the computer
 */
fun URL.download(saveDirectory: String) {
	FileUtils.download(this, saveDirectory)
}