package com.github.shanehd.utilities.net;

import java.util.HashMap;
import java.util.logging.Logger;

import com.github.shanehd.utilities.StringUtils;

/**
 * @author https://www.github.com/ShaneHD
 */
public class PacketHandler {
	private final NetworkHelper out;
	protected final Logger log;
	public final HashMap<String, Command> commands = new HashMap<String, Command>();
	public final HashMap<String, Command.NoArgs> noargCommands = new HashMap<String, Command.NoArgs>();

	public PacketHandler(NetworkHelper out, Logger log) {
		this.out = out;
		this.log = log;
	}
	
	/** 
	 * Handle input
	 */
	public void handle(String s) {
		try {
			noargCommands.get(s.toLowerCase()).handle(out, s);
		} catch(Exception e) {
			e.printStackTrace();
			log.warning("Command " + StringUtils.quote(s) + " failed. No args.");
		}
	}
	
	/**
	 * with arguments
	 * @see {@link #handle(String)}
	 */
	public void handle(String s, String[] args) {		
		try {
			commands.get(s.toLowerCase()).handle(out, s, args[1], args); 
		} catch(Exception e) {
			e.printStackTrace();
			log.warning("Command " + StringUtils.quote(s) + " failed.");
			
			for(String s1 : args)
				log.warning("[ARG]: " + s1);
			
			log.warning("[end of args]");
		}
	}
}
