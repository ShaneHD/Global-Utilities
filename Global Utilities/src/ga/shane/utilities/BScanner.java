package ga.shane.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.util.Scanner;

/** @author http://www.shane.ga */
public class BScanner {
	private final Scanner scanner;
	
	public BScanner(File source) throws FileNotFoundException {
		scanner = new Scanner(source);
	}
	
	public BScanner(InputStream source) {
		scanner = new Scanner(source);
	}
	
	public BScanner(Path source) throws IOException {
		scanner = new Scanner(source);
	}
	
	public BScanner(Readable source) {
		scanner = new Scanner(source);
	}
	
	public BScanner(ReadableByteChannel source) {
		scanner = new Scanner(source);
	}
	
	public BScanner(String source) {
		scanner = new Scanner(source);
	}
	
	public BScanner(File source, String charsetName) throws FileNotFoundException {
		scanner = new Scanner(source, charsetName);
	}
	
	public BScanner(InputStream source, String charsetName) {
		scanner = new Scanner(source, charsetName);
	}
	
	public BScanner(Path source, String charsetName) throws IOException {
		scanner = new Scanner(source, charsetName);
	}
	
	public BScanner(ReadableByteChannel source, String charsetName) {
		scanner = new Scanner(source, charsetName);
	}
	
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
