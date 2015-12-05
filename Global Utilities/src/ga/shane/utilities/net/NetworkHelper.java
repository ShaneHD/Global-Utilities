package ga.shane.utilities.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author https://www.github.com/ShaneHD
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
	
	public void write(String packet, String... args) throws Exception {		
		throw new RuntimeException("Not set up.");
	}
	
	public static class DataStreamNetworkHelper extends NetworkHelper<DataInputStream, DataOutputStream> {
		public DataStreamNetworkHelper(DataInputStream input, DataOutputStream output) {
			super(input, output);
		}
		
		@Override
		public void write(String packet, String... args) throws Exception {
			try {
				if(args.length == 0)
					((DataOutputStream)output).writeUTF(packet);
				else {
					String argsSendFormat = packet + Command.SEPARATOR;
					
					for(int i = 0; i < args.length; i++)
						argsSendFormat+= args[i] + (i == args.length - 1 ? "" : Command.SEPARATOR);
					
					write(argsSendFormat);
				}
			} catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
}
