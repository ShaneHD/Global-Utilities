package com.github.shanehd.utilities;

/** @author https://www.github.com/ShaneHD */
public class Wrapper<T> {
	public T value;
	
	public Wrapper(T value) {
		this.value = value;
	}
	
	public Wrapper() {
		
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
