package com.github.shanehd.utilities.json.assetloading;

import com.github.shanehd.utilities.FileUtils;
import com.github.shanehd.utilities.MapUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.util.HashMap;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
public class JsonAssetLoader {
    private final JSONParser json;
    private final AssetLoader loader;

    public JsonAssetLoader() {
        json = new JSONParser();
        loader = new AssetLoader();
    }

    public HashMap<String, Object> load(File file) throws Exception {
        HashMap<String, Object> loaded = new HashMap<>();
        JSONObject root = (JSONObject) json.parse(FileUtils.getFileContents(file));

        for(Object id : root.keySet()) {
            String type = (String) id;
            Object value = root.get(type);

            if(!(value instanceof JSONObject))
                continue;

            JSONObject assets = (JSONObject) value;

            MapUtils.iterate(assets, (o, o2) -> {
                final String a_id = (String) o;
                String a_info = (String) o2;

                try {
                    if(a_info.contains("%%")) {
                        String[] split = a_info.split("%%");

                        for(int i = 1; i < split.length; i+= 2) {
                            String lid = split[i];
                            a_info = a_info.replaceAll("%%" + lid + "%%", root.get(lid).toString());
                        }
                    }

                    loaded.put(a_id, loader.load(type, a_info));
                } catch(Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        return loaded;
    }
}
