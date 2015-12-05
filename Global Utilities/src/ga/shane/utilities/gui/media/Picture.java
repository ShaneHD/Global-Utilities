package ga.shane.utilities.gui.media;

import ga.shane.utilities.FileUtils;
import ga.shane.utilities.ImageUtils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Picture extends Media<BufferedImage> {
	public Picture(BufferedImage value, int x, int y) {
		super(value, x, y);
	}

	public Picture(BufferedImage value, int x, int y, int width, int height) {
		super(value, x, y, width, height);
	}
	
	public Picture(File dir, int x, int y) {
		super(ImageUtils.load(dir), x, y);
	}
	
	public Picture(File dir, int x, int y, int width, int height) {
		super(ImageUtils.load(dir), x, y, width, height);
	}
	
	public Picture(String dir, int x, int y) {
		super(ImageUtils.load(FileUtils.newFile(dir)), x, y);
	}
	
	public Picture(String dir, int x, int y, int width, int height) {
		super(ImageUtils.load(FileUtils.newFile(dir)), x, y, width, height);
	}
	
	@Override
	public int getWidth() {
		int width = super.getWidth();
		
		if(width <= 0)
			return getValue().getWidth();
		
		return width;
	}
	
	@Override
	public int getHeight() {
		int height = super.getHeight();
		
		if(height <= 0)
			return getValue().getHeight();
		
		return height;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(getValue(), getX(), getY(), getWidth(), getHeight(), null);
	}
}
