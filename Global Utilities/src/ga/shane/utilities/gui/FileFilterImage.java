package ga.shane.utilities.gui;

import ga.shane.utilities.ImageUtils;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/** @author http://www.shane.ga */
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
