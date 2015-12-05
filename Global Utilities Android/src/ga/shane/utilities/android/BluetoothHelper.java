package ga.shane.utilities.android;

import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;

//Note that most code below is made by viewing examples from google
//It is NOT made by me off of the top of my head 

/** @author https://www.github.com/ShaneHD */
public class BluetoothHelper {
	private final BluetoothAdapter btAdapter;
	private final Set<BluetoothDeviceWrapper> devices;
	
	public BluetoothHelper() {
		Activity main = AndroidUtils.getMainActivity();
		btAdapter = BluetoothAdapter.getDefaultAdapter();
		
		if(!isBluetoothSupported()) {
			AndroidUtils.toast("Bluetooth isn't supported!");
			main.finish();
		}
		
		if(!btAdapter.isEnabled())
			main.startActivityForResult(new Intent(btAdapter.ACTION_REQUEST_ENABLE), 1);
			
		devices = new HashSet<BluetoothDeviceWrapper>();
		
		for(BluetoothDevice device : btAdapter.getBondedDevices())
			devices.add(new BluetoothDeviceWrapper(device));
	}
	
	/**
	 * Is the {@link Set} of paired devices empty<br>
	 * Returns true when no devices are paired
	 */
	public boolean isEmpty() {
		return devices.size() == 0;
	}
	
	/**
	 * @return A {@link Set} containing all paired devices
	 */
	public Set<BluetoothDeviceWrapper> getPairedDevices() {
		return devices;
	}
	
	/**
	 * Call this in the main activity's onActivityResult(int, int, Intent) method<br>
	 * TODO look into a listener for this
	 */
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == Activity.RESULT_CANCELED) {
			AndroidUtils.toast("Bluetooth must be enabled to use this feature.");
			AndroidUtils.getMainActivity().finish();
		}	
	}
	
	/**
	 * @return Whether bluetooth is supported or not
	 */
	public boolean isBluetoothSupported() {
		return btAdapter != null;
	}
}
