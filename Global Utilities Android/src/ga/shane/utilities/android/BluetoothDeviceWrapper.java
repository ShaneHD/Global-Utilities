package ga.shane.utilities.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

/**
 * Wraps around {@link BluetoothDevice} to add more functionality<br>
 * Adds methods to send data to this device (TODO)
 * 
 * @see {@link #getBluetoothDevice()}
 * @author https://www.github.com/ShaneHD
 */
public class BluetoothDeviceWrapper implements IBluetoothDevice {
	private final BluetoothDevice device;
	private final OutputStream out;
	private final InputStream in;
	
	public BluetoothDeviceWrapper(BluetoothDevice device) {
		this.device = device;
	
		OutputStream out;
		InputStream in;
		
		try {
			BluetoothSocket socket = device.createRfcommSocketToServiceRecord(device.getUuids()[0].getUuid());
			
			out = socket.getOutputStream();
			in = socket.getInputStream();
		} catch (IOException e) {
			out = null;
			in = null;
			e.printStackTrace();
		}
        
		this.out = out;
		this.in = in;
	}
	
	/**
	 * Send a {@link String} in byte[] form to the device
	 */
	public void send(String text) {
		try {
			out.write(text.getBytes());
		} catch (IOException e) {
			AndroidUtils.error("Couldn't write String: \"" + text + "\"", e);
		}
	}
	
	/**
	 * @return The {@link BluetoothDevice} instance
	 */
	public BluetoothDevice getBluetoothDevice() {
		return device;
	}

	@Override
	public String getAddress() {
//		I use the getter in case at some point it returns a different value for whatever reason
		return getBluetoothDevice().getAddress();
	}

	@Override
	public String getName() {
		return getBluetoothDevice().getName();
	}
}

interface IBluetoothDevice {
	String getAddress();
	String getName();
}
