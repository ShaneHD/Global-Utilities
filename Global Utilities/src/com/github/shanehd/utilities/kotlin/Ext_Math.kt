package com.github.shanehd.utilities.kotlin

import com.github.shanehd.utilities.EMath

/** 
 * @author https://www.github.com/ShaneHD
 */

val Int.toNextEven: Int
	get() = EMath.toNextEven(this)

val Int.toLastEven: Int 
	get() = EMath.toLastEven(this)

val Int.toNextOdd: Int 
	get() = EMath.toNextOdd(this)

val Int.toLastOdd: Int
	get() = EMath.toLastOdd(this)

/**
 * Finds center location
 */
fun Int.center(maxsize: Int) : Int {
	return EMath.center(this, maxsize)
}

/**
 * Finds center location
 */
fun Float.center(maxsize: Float) : Float {
	return EMath.center(this, maxsize)
}