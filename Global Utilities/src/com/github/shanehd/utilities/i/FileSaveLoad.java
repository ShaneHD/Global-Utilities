package com.github.shanehd.utilities.i;

import java.io.File;

/**
 * For classes that can save/load from a {@link File}
 * 
 * @see {@link #load()}
 * @see {@link #save()}
 * @author https://www.github.com/ShaneHD
 */
public interface FileSaveLoad {
	boolean load();
	boolean save();
}
