package ga.shane.utilities;

/**
 * A {@link java.util.logging.Logger} wrapper<br>
 * Adds enabled support<br>
 * @see {@link #enabled}
 * @see {@link java.util.logging.Logger}
 * 
 * @author http://www.shane.ga
 */
public class Logger {
	/** The java.util.logging.Logger instance */
	public java.util.logging.Logger logger;
	/** Will logs be printed? */
	public boolean enabled = true;
	
	public Logger(String name) {
		logger = java.util.logging.Logger.getLogger(name);
	}
	
	public Logger(Class<?> c) {
		this(c.getSimpleName());
	}
	
	/**
	 * Adds {@link enabled} logic
	 * @see {@link logger}
	 * @see {@link #warning(String)}
	 */
	public void info(String msg) {
		if(enabled)
			logger.info(msg);
	}
	
	/**
	 * Adds {@link enabled} logic
	 * @see {@link logger}
	 * @see {@link #info(String)}
	 */
	public void warning(String msg) {
		if(enabled)
			logger.warning(msg);
	}
}
