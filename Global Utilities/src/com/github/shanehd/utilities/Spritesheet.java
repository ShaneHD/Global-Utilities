package com.github.shanehd.utilities;

import java.awt.image.BufferedImage;

/** @author https://www.github.com/ShaneHD */
public class Spritesheet {
	private final BufferedImage image;
	public final int width, height;
	
	public Spritesheet(BufferedImage image, int width, int height) {
		this.image = image;
		this.width = width;
		this.height = height;
	}
	
	public BufferedImage get(int x, int y) {
		return image.getSubimage(x, y, width, height);
	}
}
