package ga.shane.utilities;

/** @author http://www.shane.ga */
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
