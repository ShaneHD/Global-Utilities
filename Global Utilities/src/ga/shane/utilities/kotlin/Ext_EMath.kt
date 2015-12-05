package ga.shane.utilities.kotlin

import ga.shane.utilities.kotlin.*
import ga.shane.utilities.EMath

/** 
 * @author http://www.shane.ga
 */

val Int.toNextEven: Int
	get() = EMath.toNextEven(this)

val Int.toLastEven: Int 
	get() = EMath.toLastEven(this)

val Int.toNextOdd: Int 
	get() = EMath.toNextOdd(this)

val Int.toLastOdd: Int
	get() = EMath.toLastOdd(this)

fun Int.center(maxsize: Int) : Int {
	return EMath.center(this, maxsize)
}

fun Float.center(maxsize: Float) : Float {
	return EMath.center(this, maxsize)
}