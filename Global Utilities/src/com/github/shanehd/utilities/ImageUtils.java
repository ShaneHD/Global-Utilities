package com.github.shanehd.utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Image utilities
 * 
 * @author https://www.github.com/ShaneHD
 */
public class ImageUtils {	
	private static BufferedImage mouseCursor;
	
	/** An array of common image formats */
	public static final String[] FORMATS = {
		"png", "jpg", "jpeg", "gif", "bmp"
	};
	
	/**
	 * @see {@link FileUtils#isImage(File)}
	 */
	public static boolean isImage(File file) {
		return FileUtils.isImage(file);
	}
	
	/**
	 * Uses {@link Robot#createScreenCapture(Rectangle)} to make a {@link BufferedImage} of the screen
	 */
	public static BufferedImage createScreenCapture(Robot robot) {
		BufferedImage img = robot.createScreenCapture(new Rectangle(PCUtils.getScreenWidth(), PCUtils.getScreenHeight()));
		return img;
	}
	
	/**
	 * Draws a circle where the mouse cursor is
	 * @see {@link #createScreenCapture(Robot)}
	 */
	public static BufferedImage createScreenCaptureWithMouseCursor(Robot robot) {
		BufferedImage img = createScreenCapture(robot);

		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		Graphics2D g = img.createGraphics();

		if(mouseCursor == null)
			mouseCursor = load(FileUtils.newFileInsideClasspath("com/github/shanehd/utilities/mouse_cursor.png"));
		
		g.drawImage(mouseCursor, x, y, null);
		//g.drawRoundRect(x, y, 16, 16, 16, 16);
		return img;
	}
	
	/**
	 * Convert a {@link RenderedImage} to a byte array
	 */
	public static byte[] toByteArray(RenderedImage image) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			ImageIO.write(image, "JPG", out);
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println("Failed to convert image to byte array");
		}
		
		return out.toByteArray();
	}
	
	/**
	 * Convert byte[] to {@link BufferedImage}
	 */
	public static BufferedImage fromByteArray(byte[] bytes) {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		
		try {
			return ImageIO.read(in);
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println("Failed to convert byte array to image");
		}
		
		return null;
	}
	
	/**
	 * Resizes an image using a Graphics2D object backed by a BufferedImage.
	 * @param srcImg - source image to scale
	 * @param w - desired width
	 * @param h - desired height
	 * @return - the new resized image
	 * @author alain.janinm
	 */
	public static BufferedImage resize(final Image srcImg, final int w, final int h){
	    final BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    final Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
	
	/**
	 * Load a {@link BufferedImage} from a {@link File}
	 */
	//TODO throw excs on all methods instead of handling locally
	public static BufferedImage load(File path) {
		try {
			return ImageIO.read(path);
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static enum View {
		HORIZONTAL, VERTICAL, SQUARE;
		
		public static View what(BufferedImage img) {
			if(img.getWidth() > img.getHeight())
				return HORIZONTAL;
			
			if(img.getHeight() > img.getWidth())
				return VERTICAL;
			
			return SQUARE;
		}
		
		public boolean is(BufferedImage img) {
			return what(img) == this;
		}
	}
}
