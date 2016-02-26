package com.github.shanehd.utilities.kotlin

import java.net.URL
import com.github.shanehd.utilities.FileUtils
import java.net.HttpURLConnection

/** 
 * @author https://www.github.com/ShaneHD
 */

/**
 * Downloads a file and saves it to a location on the computer
 */
fun URL.download(saveDirectory: String) {
	FileUtils.download(this, saveDirectory)
	//FileUtils.download(this, saveDirectory)
}