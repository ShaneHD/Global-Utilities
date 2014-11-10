package ga.shane.utilities;

import ga.shane.utilities.gui.BJFrame;

import java.awt.Color;
import java.util.Random;

/**
 * Stands for BetterRandom<br>
 * Adds more functionality to {@link Random}
 * 
 *@see {@link #nextColor()}
 * @author http://www.shane.ga
 */
public class BRandom extends Random {
	public BRandom() {
		super();
	}
	
	public BRandom(long seed) {
		super(seed);
	}
	
	/**
	 * Calls {@link Color}({@link #nextFloat()}, {@link #nextFloat()}, {@link #nextFloat()}, {@link #nextFloat()})
	 * @return
	 */
	public Color nextColor() {
		return new Color(nextFloat(), nextFloat(), nextFloat(), nextFloat());
	}
	
	public float nextFloat(float min, float max) {
		return nextFloat() * (max - min) + min;
	}
	
	public int nextInt(int min, int max) {
		return nextInt(max - min) + min;
	}
	
	/**
	 * TODO remove
	 */
	@SuppressWarnings("unused")
	private static void main(String[] args) {
		final BJFrame frame = new BJFrame(){

			@Override
			protected void init() {
			}

			@Override
			protected void constructFrame() {
			}};
		frame.setSize(650, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new BRandom().nextColor());
		
		new Thread() {
			public void run() {
				while(true) {
					frame.getContentPane().setBackground(new BRandom().nextColor());
					frame.refresh();
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
