package com.github.shanehd.utilities.plugins;

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
	String name() default "null";
	
	/**
	 * The author of this plugin
	 */
	String author() default "null";
	
	/**
	 * The version of this plugin
	 */
	double version() default 1.0;
	
	Priority priority() default Priority.NORMAL;
}
