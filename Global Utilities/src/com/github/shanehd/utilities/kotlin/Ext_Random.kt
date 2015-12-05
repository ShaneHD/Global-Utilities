package com.github.shanehd.utilities.kotlin

import java.awt.Color
import java.util.Random

/** 
 * @author https://www.github.com/ShaneHD
 */

/**
 * Calls {@link Color}({@link #nextFloat()}, {@link #nextFloat()}, {@link #nextFloat()}, {@link #nextFloat()})
 */
fun Random.nextColor() : Color {
	return Color(nextFloat(), nextFloat(), nextFloat(), nextFloat())
} 

fun Random.nextFloat(min: Float, max: Float) : Float {
	return nextFloat() * (max - min) + min
}

fun Random.nextInt(min: Int, max: Int) : Int {
	return nextInt(max - min) + min;
}

/**
 * Uses {@link #nextInt(int)} to generate a random number, and returns whether it's equal to max or not<br>
 * Useful for random events with a set chance of happening
 */
fun Random.chance(max: Int) : Boolean {
	return nextInt(max + 1) == max
}