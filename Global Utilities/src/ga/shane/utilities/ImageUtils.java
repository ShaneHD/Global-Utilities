package ga.shane.utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/** @author http://www.shane.ga */
public class ImageUtils {
	/** An array of common image formats */
	public static final String[] FORMATS = {
		"png", "jpg", "jpeg", "gif", "bmp"
	};
	
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
}
