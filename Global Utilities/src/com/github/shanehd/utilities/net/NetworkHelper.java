package com.github.shanehd.utilities.net;

import java.io.*;

/**
 * A class to help handle networking<br/>
 * Stores both an {@link #input} and an {@link #output}
 *
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

	/**
	 * Write information to the {@link #output} stream
	 * @param packet Packet to send
	 * @param args Any arguments
	 */
	public void write(String packet, String... args) throws IOException {
		throw new RuntimeException("Write has not been set up...");
	}

	/**
	 * Closes the streams
	 */
	public void close() throws IOException {
		input.close();
		output.close();
	}

	/**
	 * {@link NetworkHelper} using {@link DataInputStream} and {@link DataOutputStream}
	 */
	public static class DataStreamNetworkHelper extends NetworkHelper<DataInputStream, DataOutputStream> {
		public DataStreamNetworkHelper(DataInputStream input, DataOutputStream output) {
			super(input, output);
		}
		
		@Override
		public void write(String packet, String... args) throws IOException {
			if(args.length == 0)
				((DataOutputStream)output).writeUTF(packet);
			else {
				String argsSendFormat = packet + Command.SEPARATOR;

				for(int i = 0; i < args.length; i++)
					argsSendFormat+= args[i] + (i == args.length - 1 ? "" : Command.SEPARATOR);

				write(argsSendFormat);
			}
		}
	}
}
