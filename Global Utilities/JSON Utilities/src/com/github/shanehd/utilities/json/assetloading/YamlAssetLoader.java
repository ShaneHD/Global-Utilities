package com.github.shanehd.utilities.json.assetloading;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.github.shanehd.utilities.MapUtils;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * TODO this is no longer json utils, renameit and convert Lang to yml 2
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 17/02/2017.
 */
public class YamlAssetLoader extends AssetLoader {
    @Override
    public HashMap<String, Object> load(File file) throws Exception {
        HashMap<String, Object> loaded = new HashMap<>();
        YamlReader yml = new YamlReader(new FileReader(file));
        HashMap data = (HashMap) yml.read();

        MapUtils.iterate(data, (o, o2) -> {
            String clazz = (String) o;
            HashMap contents = (HashMap) o2;

            MapUtils.iterate(contents, (o1, o21) -> {
                String id = (String) o1;
                String value = (String) o21;

                try {
                    Object load = load(clazz, value);

                    if(loaders.get(clazz).shouldAddToLoadedAssets())
                        loaded.put(id, load);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });

        return loaded;
    }

}
