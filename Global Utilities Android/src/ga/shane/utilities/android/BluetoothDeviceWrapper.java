package ga.shane.utilities.android;

import android.bluetooth.BluetoothDevice;

/**
 * Wraps around {@link BluetoothDevice} to add more functionality<br>
 * Adds methods to send data to this device (TODO)
 * 
 * @see {@link #getBluetoothDevice()}
 * @author http://www.shane.ga
 */
public class BluetoothDeviceWrapper implements IBluetoothDevice {
	private final BluetoothDevice device;
	
	public BluetoothDeviceWrapper(BluetoothDevice device) {
		this.device = device;		
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