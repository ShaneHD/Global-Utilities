package ga.shane.utilities;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/** 
 * Stands for BetterFile<br>
 * Adds support for checking whether the file has been newly created<br>
 * (whether {@link #createNewFile()} has been called)
 * 
 * @see {@link #isNewFile()}
 * @see {@link File}
 * @author https://www.github.com/ShaneHD 
*/
public class BFile extends File {
	private boolean newlyCreated;
	
	public BFile(String arg0) {
		super(arg0);
	}
	
	public BFile(URI arg0) {
		super(arg0);
	}
	
	public BFile(File arg0, String arg1) {
		super(arg0, arg1);
	}
	
	public BFile(String arg0, String arg1) {
		super(arg0, arg1);
	}
	
	@Override
	public boolean createNewFile() throws IOException {
		newlyCreated = true;
		return super.createNewFile();
	}
	
	/**
	 * @return Has this {@link File} been created in this session?<br>
	 * (has {@link #createNewFile()} been called)
	 */
	public boolean isNewFile() {
		return newlyCreated;
	}
}
