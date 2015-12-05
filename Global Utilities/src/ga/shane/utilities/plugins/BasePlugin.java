package ga.shane.utilities.plugins;

/** 
 * Base class for an external plugin<br>
 * <b style='color:red;'>Annotate class with {@link PluginInfo}</b>
 * 
 * @author https://www.github.com/ShaneHD
 */
public interface BasePlugin<T> {
	void load(T arg);
}
