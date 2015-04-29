package ga.shane.utilities.experimental;

import ga.shane.utilities.FileUtils;

import java.io.File;

/** 
 * {@link BasePlugin} loader
 * 
 * @author http://www.shane.ga
 */
public class ExternalPluginLoader {
	public final File dir;
	
	/**
	 * <b style='color:red;'>Warning: uses {@link FileUtils#workingDirectory}/plugins</b>
	 */
	public ExternalPluginLoader() {
		dir = new File(FileUtils.workingDirectory, "plugins/");
	}
}
