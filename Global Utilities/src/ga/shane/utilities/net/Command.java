package ga.shane.utilities.net;

/**
 * @author http://www.shane.ga
 */
public interface Command {
	public static String SEPARATOR = "`SEP`";
	
	void handle(NetworkHelper out, String command, String sub, String[] args) throws Exception;
	
	static interface NoArgs {
		void handle(NetworkHelper out, String command);
	}
}
