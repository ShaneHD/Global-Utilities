package ga.shane.utilities.experimental;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @author http://www.shane.ga
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PluginInfo {	
	/**
	 * The author of this plugin
	 */
	public String author() default "null";
	
	/**
	 * The version of this plugin (will be used for updating, and possibly on a plugin repo)
	 */
	public double version() default 1.0;
}
