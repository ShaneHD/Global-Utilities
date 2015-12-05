package ga.shane.utilities.plugins;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @author https://www.github.com/ShaneHD
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PluginInfo {	
	/**
	 * The name of this plugin
	 */
	public String name() default "null";
	
	/**
	 * The author of this plugin
	 */
	public String author() default "null";
	
	/**
	 * The version of this plugin
	 */
	public double version() default 1.0;
}
