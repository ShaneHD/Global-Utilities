package ga.shane.utilities.gui;

import java.util.LinkedHashMap;

import javax.swing.JLabel;

import ga.shane.utilities.MapIterator;
import ga.shane.utilities.MapUtils;
import ga.shane.utilities.StringUtils;

/**
 * A {@link JLabel} that displays the amount of time that has passed (H:M:S)
 *
 *@author http://www.shane.ga
 */
public class JTimer extends JLabel implements Runnable {
	private boolean paused, showEmptyValues = true;
	private Thread thread;
	
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
	
	public void fromString(String s) {
		String[] split = s.split(":");
		
		for(String string : split) {
			String[] cur = string.split(",");
			String k = cur[0];
			int v = Integer.parseInt(cur[1]);
			
			times.put(k, v);
		}
	}
	
	public String toString() {		
		final StringBuilder s = new StringBuilder();
		
		MapUtils.iterate(times, new MapIterator() {			
			public void on(Object k, Object v) {
				s.append(k + "," + v + ":");
			}
		});		
		
		return s.toString();
	}
	
	/**
	 * Should the value '0' be drawn?
	 */
	public void setShowEmptyValues(boolean showEmptyValues) {
		this.showEmptyValues = showEmptyValues;
	}
	
	public boolean setPaused(boolean paused) {
		return this.paused = paused;
	}
	
	public boolean togglePause() {
		return setPaused(!paused);
	}
	
	public synchronized boolean isPaused() {
		return paused;
	}

	/**
	 * Started the timer thread
	 */
	public void start() {
		thread.start();
	}

	public JTimer() {
		thread = new Thread(this);
	}

	@Override
	public void run() {
		while(true) {			
			if(isPaused()) {
				
				continue;
			}
			
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
}
