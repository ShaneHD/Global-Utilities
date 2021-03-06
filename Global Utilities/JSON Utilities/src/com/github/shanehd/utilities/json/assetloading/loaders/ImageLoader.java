package com.github.shanehd.utilities.json.assetloading.loaders;

import com.github.shanehd.utilities.ImageUtils;
import com.github.shanehd.utilities.json.assetloading.Loader;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
public class ImageLoader extends Loader<BufferedImage> {
    public ImageLoader() {
        super(BufferedImage.class);
    }

    @Override
    public BufferedImage load(String info) throws Exception {
        return ImageUtils.load(new File(info));
    }
}
