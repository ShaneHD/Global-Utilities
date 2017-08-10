package com.github.shanehd.utilities.net;

/**
 *
 * TODO switch to annotation based commands
 * @author https://www.github.com/ShaneHD
 */
public interface Command<T extends NetworkHelper> {
	/** The {@link String} that separates arguments when sending {@link Command}s */
	String SEPARATOR = "`SEP`";
	
	void handle(T out, String command, String sub, String[] args) throws Exception;
	
	interface NoArgs<T extends NetworkHelper> {
		void handle(T out, String command);
	}
}
