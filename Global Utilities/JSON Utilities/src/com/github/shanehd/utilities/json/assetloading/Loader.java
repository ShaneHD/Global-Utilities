package com.github.shanehd.utilities.json.assetloading;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
public interface Loader<T> {
    T load(String info) throws Exception;
}
