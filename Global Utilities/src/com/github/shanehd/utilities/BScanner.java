package com.github.shanehd.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

/**
 * Better {@link Scanner}<br/>
 * Useful when getting input from command line
 *
 * @author https://www.github.com/ShaneHD
 */
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

	/**
	 * Get input from the {@link Scanner}
	 * @param message Use this if you want to print out a message before waiting for input
	 * @return The input in {@link String} form
	 */
	public String input(String... message) {
		if(message.length != 0)
			System.out.println(message[0]);
			
		return scanner.nextLine();
	}

	/**
	 * Get <code>int</code> input
	 * @param message Use this if you want to print out a message before waiting for input
	 * @return The input in <code>int</code> form
	 * @throws NumberFormatException
	 */
	public int iinput(String... message) throws NumberFormatException {
		return Integer.parseInt(input(message));
	}

	/**
	 * Get <code>float</code> input
	 * @param message Use this if you want to print out a message before waiting for input
	 * @return The input in <code>float</code> form
	 * @throws NumberFormatException
	 */
	public float finput(String... message) throws NumberFormatException {
		return Float.parseFloat(input(message));
	}

	/**
	 * Get <code>boolean</code> input
	 * @param message Use this if you want to print out a message before waiting for input
	 * @return The input in <code>boolean</code> form
	 */
	public boolean binput(String... message) {
		return Boolean.parseBoolean(input(message));
	}

	/**
	 * Get <code>char</code> input
	 * @param message Use this if you want to print out a message before waiting for input
	 * @return The input in <code>char</code> form
	 */
	public char cinput(String... message) {
		return input(message).charAt(0);
	}

	/**
	 * Get <code>long</code> input
	 * @param message Use this if you want to print out a message before waiting for input
	 * @return The input in <code>long</code> form
	 */
	public long linput(String... message) throws NumberFormatException {
		return Long.parseLong(input(message));
	}

	/**
	 * The {@link Scanner} that this wrapper is assigned to
	 */
	public Scanner getScanner() {
		return scanner;
	}
}
