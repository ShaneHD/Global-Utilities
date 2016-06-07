package com.github.shanehd.utilities.net;

/**
 * @author https://www.github.com/ShaneHD
 */
public interface Command<T extends NetworkHelper> {
	String SEPARATOR = "`SEP`";
	
	void handle(T out, String command, String sub, String[] args) throws Exception;
	
	interface NoArgs<T extends NetworkHelper> {
		void handle(T out, String command);
	}
}
