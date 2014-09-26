package ga.shane.utilities;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * TODO
 * 
 * @author http://www.shane.ga
 *
 * @param <IN> The {@link InputStream} type
 * @param <OUT> The {@link OutputStream} type
 */
public abstract class NetworkHelper<IN extends InputStream, OUT extends OutputStream> {
	public final IN input;
	public final OUT output;
	
	public NetworkHelper(IN input, OUT output) {
		this.input = input;
		this.output = output;
	}
	
	public abstract void write(Object o);
}
