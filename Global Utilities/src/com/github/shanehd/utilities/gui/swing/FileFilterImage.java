package com.github.shanehd.utilities.gui.swing;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import com.github.shanehd.utilities.ImageUtils;

/**
 * A {@link FileFilter} for images<br>
 * (Uses {@link ImageUtils#isImage(File)})
 * 
 * @author https://www.github.com/ShaneHD
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
