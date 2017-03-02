package com.github.shanehd.utilities.json.assetloading;

import com.github.shanehd.utilities.StringUtils;
import com.github.shanehd.utilities.json.assetloading.loaders.FileLoader;
import com.github.shanehd.utilities.json.assetloading.loaders.ImageLoader;
import com.github.shanehd.utilities.json.assetloading.loaders.SoundLoader;

import java.io.File;
import java.util.HashMap;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
abstract class AssetLoader {
    protected final HashMap<String, Loader> loaders = new HashMap<>();

    public AssetLoader() {
        addType(new FileLoader());
        addType(new ImageLoader());
        addType(new SoundLoader());
    }

    public abstract HashMap<String, Object> load(File file) throws Exception;

    public void addType(Loader loader) {
        loaders.put(loader.type, loader);
    }

    protected Object load(String type, String info) throws Exception {
        if(!loaders.containsKey(type))
            throw new IllegalArgumentException("There isn't an asset loader for type " + StringUtils.quote(type) + "...");

        return loaders.get(type).load(info);
    }
}
