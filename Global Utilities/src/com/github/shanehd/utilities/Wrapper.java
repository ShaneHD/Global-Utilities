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
	public boolean equals(Object obj) {
		return value.equals(obj);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
