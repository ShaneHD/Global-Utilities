package com.github.shanehd.utilities.plugins;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

import com.github.shanehd.utilities.FileUtils;
import com.github.shanehd.utilities.Log;
import com.github.shanehd.utilities.StringUtils;

/** 
 * {@link BasePlugin} loader
 * 
 * @author https://www.github.com/ShaneHD
 */
public class ExternalPluginLoader {
	public final File dir;
	private final LinkedHashSet<BasePlugin> plugins = new LinkedHashSet<BasePlugin>();

	/**
	 * <b style='color:red;'>Warning: uses {@link FileUtils#workingDirectory}/plugins</b>
	 */
	public ExternalPluginLoader() {
		dir = new File(FileUtils.workingDirectory, "plugins/");
	}
	
	@SuppressWarnings("unchecked")
	private void load(File file, String _class, Object arg) throws Exception {
		@SuppressWarnings("deprecation")
		URLClassLoader  loader = new URLClassLoader(new URL[]{file.toURL()}, getClass().getClassLoader());
		Class pluginClass = loader.loadClass(_class);
		
		BasePlugin current = (BasePlugin) pluginClass.newInstance();
		current.load(arg);
		plugins.add(current);
		
		loader.close();
	}
	
	// TODO error handling 
	public LinkedHashSet<BasePlugin> loadPlugins(Object arg) {
		plugins.clear();

		for(File file : dir.listFiles()) {
			String name = file.getName();
			
			if(!name.endsWith(".jar"))
				continue;
			
			Log.get().info("= Found plugin jar: " + name + " =");
			String main = null;
			
			try {				
				JarFile jar = new JarFile(file);
				JarEntry entry = jar.getJarEntry("plugin.info");
				
				InputStream in = jar.getInputStream(entry);
				Scanner scanner = new Scanner(in);
				main = scanner.nextLine().split("main=")[1];
				
				scanner.close();
				jar.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(main == null) {
				Log.get().warning("main property in plugin.info is null, for " + StringUtils.quote(file.getAbsolutePath()));
				continue;
			}
			
			try {
				if(main.contains(",")) {
					String[] multiple = main.split(",");
					
					for(String _class : multiple)
						load(file, _class, arg);
				} else 
					load(file, main, arg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return plugins;
	}
}
