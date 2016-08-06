package com.github.shanehd.utilities.json.assetloading.loaders;

import com.github.shanehd.utilities.Sound;
import com.github.shanehd.utilities.json.assetloading.Loader;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
public class SoundLoader extends Loader<Sound> {
    @Override
    public Sound load(String info) throws Exception {
        return new Sound(info);
    }
}
