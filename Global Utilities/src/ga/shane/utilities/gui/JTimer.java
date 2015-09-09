package ga.shane.utilities.gui;

import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ga.shane.utilities.MapIterator;
import ga.shane.utilities.MapUtils;
import ga.shane.utilities.StringUtils;

public class JTimer extends JLabel {
	private boolean showEmptyValues = true;
	
	public void setShowEmptyValues(boolean showEmptyValues) {
		this.showEmptyValues = showEmptyValues;
	}
	
	private final LinkedHashMap<String, Integer> times = new LinkedHashMap<String, Integer>() {
		{
			String[] times = {
				"s",
				"m",
				"h"
			};
			
			for(String time : times)
				put(time, 0);
		}
	};
	
	public JTimer(long delay) {	
		new Thread() {
			public void run() {
				while(true) {
					times.put("s", times.get("s") + 1);
					
					if(times.get("s") >= 60) {
						times.put("s", 0);
						times.put("m", times.get("m") + 1);
					}
					
					if(times.get("m") >= 60) {
						times.put("m", 0);
						times.put("h", times.get("h") + 1);
					}
					
					setText("");
					
					MapUtils.iterate(times, new MapIterator.Reverse<String, Integer>() {
						public void on(String k, Integer v) {
							if(!showEmptyValues && v == 0)
								return;
								
							setText(getText() + v + ":");
						}
					});

					setText(StringUtils.replaceLast(getText(), ":", ""));
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	public static void main(String[] args) {
		JTimer timer = new JTimer(0);
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(650, 400);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(timer);
		}
}