package ga.shane.utilities;

import java.util.Scanner;

/** @author http://www.shane.ga */
public class SysteminScanner {
	private final Scanner scanner = new Scanner(System.in);
	
	public String input(String... message) {
		if(message.length != 0)
			System.out.println(message[0]);
			
		return scanner.nextLine();
	}
	
	public int iinput(String... message) throws NumberFormatException {
		return Integer.parseInt(input(message));
	}
	
	public float finput(String... message) throws NumberFormatException {
		return Float.parseFloat(input(message));
	}
	
	public boolean binput(String... message) {
		return Boolean.parseBoolean(input(message));
	}
	
	public char cinput(String... message) {
		return input(message).charAt(0);
	}
	
	public long linput(String... message) throws NumberFormatException {
		return Long.parseLong(input(message));
	}
}
