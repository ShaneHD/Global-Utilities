package ga.shane.utilities.net;

/**
 * @author https://www.github.com/ShaneHD
 */
public interface Command {
	public static String SEPARATOR = "`SEP`";
	
	void handle(NetworkHelper out, String command, String sub, String[] args) throws Exception;
	
	static interface NoArgs {
		void handle(NetworkHelper out, String command);
	}
}
