package com.github.shanehd.utilities.json.assetloading;

import com.github.shanehd.utilities.StringUtils;
import com.github.shanehd.utilities.json.assetloading.loaders.FileLoader;
import com.github.shanehd.utilities.json.assetloading.loaders.ImageLoader;
import com.github.shanehd.utilities.json.assetloading.loaders.SoundLoader;

import java.util.HashMap;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
class AssetLoader {
    private final HashMap<String, Loader> LOADERS = new HashMap<>();

    public AssetLoader() {
        LOADERS.put("FILE", new FileLoader());
        LOADERS.put("BUFFERED_IMAGE", new ImageLoader());
        LOADERS.put("SOUND", new SoundLoader());
    }

    public Object load(String type, String info) throws Exception {
        if(!LOADERS.containsKey(type))
            throw new IllegalArgumentException("There isn't an asset loader for type " + StringUtils.quote(type) + "...");

        return LOADERS.get(type).load(info);
    }
}
