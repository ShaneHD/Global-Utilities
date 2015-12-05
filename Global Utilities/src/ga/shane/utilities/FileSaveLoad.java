package ga.shane.utilities;

import java.io.File;

/**
 * For classes that can save/load from a {@link File}
 * 
 * @see {@link #load()}
 * @see {@link #save()}
 * @author http://www.shane.ga
 */
public interface FileSaveLoad {
	boolean load();
	boolean save();
}
