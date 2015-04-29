package ga.shane.utilities.experimental;

/** 
 * Base class for an external plugin
 * 
 * @author http://www.shane.ga
 */
public abstract class BasePlugin<T> {
	public abstract void load(T arg);
	
	/**
	 * The version of this plugin (will be used for updating, and possibly on a plugin repo)
	 */
	/*public double version() {
		//return 1.0;
	}*/
	public abstract double version();
	
	/**
	 * The author of this plugin
	 */
	/*public String author() {
		return "http://www.shane.ga";
	}*/
	public abstract String author();
}
