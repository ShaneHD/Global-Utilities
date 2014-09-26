package ga.shane.utilities.gui;

import ga.shane.utilities.ImageUtils;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Simply a {@link FileFilter} for images<br>
 * (Uses {@link ImageUtils#isImage(File)})
 * 
 * @see {@link FileFilter}
 * @author http://www.shane.ga
 */
public class FileFilterImage extends FileFilter {

	@Override
	public boolean accept(File f) {
		return ImageUtils.isImage(f);
	}

	@Override
	public String getDescription() {
		return "Images";
	}
}
