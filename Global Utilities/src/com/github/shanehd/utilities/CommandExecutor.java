package com.github.shanehd.utilities;

/**
 * @author https://www.github.com/ShaneHD
 */
public interface CommandExecutor {
	void execute(String command, String sub, String[] args) throws Exception;
}