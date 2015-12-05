package ga.shane.utilities;

/**
 * @author http://www.shane.ga
 */
public interface CommandExecutor {
	void execute(String command, String sub, String[] args) throws Exception;
}
