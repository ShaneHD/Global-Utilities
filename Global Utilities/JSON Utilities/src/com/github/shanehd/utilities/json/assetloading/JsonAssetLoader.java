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

            JSONObject assets = (JSONObject) root.get(type);

            MapUtils.iterate(assets, (o, o2) -> {
                final String a_id = (String) o;
                String a_info = (String) o2;

                //TODO maybe idk
                /*if(a_info.contains("%")) {
                    String[] split = a_info.split("%");

                    for(int i = 0; i < split.length - 1; i+= 2) {
                        String key = split[i + 1];
                        a_info = a_info.replace("%" + key + "%", ""+loaded.get(key));
                    }
                }*/

                try {
                    loaded.put(a_id, loader.load(type, a_info));
                } catch(Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        return loaded;
    }
}
