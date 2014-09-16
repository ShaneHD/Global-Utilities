package ga.shane.utilities;

import java.io.InputStream;
import java.io.OutputStream;

/** @author http://www.shane.ga */
public abstract class NetworkHelper<IN extends InputStream, OUT extends OutputStream> {
	public final IN input;
	public final OUT output;
	
	public NetworkHelper(IN input, OUT output) {
		this.input = input;
		this.output = output;
	}
	
	public abstract void write(Object o);
}
