package com.github.shanehd.utilities.net;

import java.util.HashMap;
import java.util.logging.Logger;

import com.github.shanehd.utilities.StringUtils;

/**
 * Processes incoming {@link Command}s<br/>
 * Simply place [label, command instance] into {@link #commands} or {@link #noargCommands},
 * 		and call either {@link #handle(String)} or {@link #handle(String, String[])} depending
 * 		on whether arguments are present or not
 *
 * @author https://www.github.com/ShaneHD
 */
public class PacketHandler {
	private final NetworkHelper out;
	protected final Logger log;
	/** A {@link java.util.Map} of all added {@link Command}s */
	public final HashMap<String, Command> commands = new HashMap<String, Command>();
	/** A {@link java.util.Map} of all added {@link com.github.shanehd.utilities.net.Command.NoArgs} */
	public final HashMap<String, Command.NoArgs> noargCommands = new HashMap<String, Command.NoArgs>();

	public PacketHandler(NetworkHelper out, Logger log) {
		this.out = out;
		this.log = log;
	}

	private void error(String command, int argsSize, Throwable t) {
		t.printStackTrace();
		log.warning("Command " + StringUtils.quote(command) + " failed with args size " + StringUtils.quote(argsSize) + "; INFO= " + StringUtils.format(t));
	}

	/**
	 * @return The requested command
	 * @throws IllegalArgumentException If the command isn't added
     */
	private Object safeget(String command, HashMap commands) throws NullPointerException {
		if(!commands.containsKey(command))
			throw new NullPointerException("Command " + StringUtils.quote(command) + " doesn't exist!");

		return commands.get(command);
	}

	/**
	 * Handle an incoming {@link Command} with no arguments
	 */
	@SuppressWarnings("unchecked")
	public final void handle(String command) {
		try {
			((Command.NoArgs) safeget(command, noargCommands)).handle(out, command);
		} catch(Exception e) {
			error(command, 0, e);
		}
	}
	
	/**
	 * Handle an incoming {@link Command} with arguments
	 */
	@SuppressWarnings("unchecked")
	public final void handle(String command, String[] args) {
		try {
			((Command) safeget(command, commands)).handle(out, command, args[1], args);
		} catch(Exception e) {
			error(command, args.length, e);
		}
	}
}
