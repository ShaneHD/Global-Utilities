package com.github.shanehd.utilities.json.assetloading.loaders;

import com.github.shanehd.utilities.json.assetloading.Loader;

import java.io.File;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
public class FileLoader extends Loader<File> {
    public FileLoader() {
        super(File.class);
    }

    @Override
    public File load(String info) throws Exception {
        return new File(info);
    }
}
