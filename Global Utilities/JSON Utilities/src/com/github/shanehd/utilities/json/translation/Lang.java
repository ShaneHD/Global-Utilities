package com.github.shanehd.utilities.json.translation;

import com.github.shanehd.utilities.FileUtils;
import com.github.shanehd.utilities.Log;
import com.github.shanehd.utilities.MapUtils;
import com.github.shanehd.utilities.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * For programs supporting multiple languages<br/>
 * Contains all available language names
 *
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 06/08/2016.
 */
public class Lang extends ArrayList<String> {
    private final HashMap<String, Object> map = new HashMap<>();
    private final File dir;
    private final JSONParser json;
    private String current;
    private HashMap<String, Object> settings;

    public Lang(File dir) {
        this.dir = dir;
        json = new JSONParser();

        for(File language : dir.listFiles()) {
            String name = language.getName();

            if(language.isDirectory() || !name.endsWith(".json"))
                continue;

            add(FileUtils.getNameWithoutExtension(language));
        }
    }

    public void setLanguageToEnglish() {
        setLanguage("english");
    }

    public void setLanguage(String language) {
        if(current != null && current == language) {
            Log.get().warning("Trying to set language to " + StringUtils.quote(language) + ", but it is already the current language.");
            return;
        }

        if(!contains(language))
            throw new IllegalArgumentException(language);

        current = language;
        map.clear();

        try {
            JSONObject root = (JSONObject) json.parse(FileUtils.getFileContents(new File(dir, current + ".json")));

            MapUtils.iterate(root, (o, o2) -> {
                map.put((String) o, o2);
            });
        } catch(ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String parse(String content, Object... args) {
        if(!content.contains("%"))
            return content;

        String[] split = content.split("%");

        for(int i = 1; i < split.length; i+= 2) {
            String arg = split[i];

            if(arg.contains("arg"))
                content = content.replace("%" + arg + "%", args[Integer.parseInt(arg.split("arg")[1]) - 1].toString());
            else if(settings != null)
                content = content.replace("%" + arg + "%", settings.get(arg).toString());
        }

        return content;
    }

    private String tryget(String id, Object... args) {
        try {
            if(id.contains("/")) {
                String[] split = id.split("/");
                JSONObject lroot = null;

                for(int i = 0; i < split.length - 1; i++) {
                    String sub = split[i];

                    if(lroot == null)
                        lroot = (JSONObject) map.get(sub);
                    else
                        lroot = (JSONObject) lroot.get(sub);
                }

                return parse((String) lroot.get(split[split.length - 1]), args);
            }

            return parse((String) map.get(id), args);
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return this + " missing arguments for id " + StringUtils.quote(id) + "..";
        }  catch(NullPointerException e) {
            e.printStackTrace();
            return error(id);
        }
    }

    private String error(String id) {
        return this + " has no defined value for " + StringUtils.quote(id);
    }

    public String get(String id, Object... args) {
        if(current == null)
            throw new IllegalStateException("Use setLanguage(name)");

        String result = tryget(id, args);
        return result.equals("null") ? error(id) : result;
    }

    @Override
    public String toString() {
        return "[Language=" + current + "]";
    }

    public String getCurrent() {
        return current;
    }

    public void setSettings(HashMap<String, Object> settings) {
        this.settings = settings;
    }
}
