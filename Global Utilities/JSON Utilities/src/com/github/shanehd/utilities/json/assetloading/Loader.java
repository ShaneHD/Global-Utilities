package com.github.shanehd.utilities.json.assetloading;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
public abstract class Loader<T> {
    /** {@link Class#getName()} */
    public final String type;

    public Loader(Class type) {
        this.type = type.getName();
    }

    /** When calling {@link #load(String)} should the loaded value be added to the map? */
    public boolean shouldAddToLoadedAssets() {
        return true;
    }

    public abstract T load(String info) throws Exception;
}
