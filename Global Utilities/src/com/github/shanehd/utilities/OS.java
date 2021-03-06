package com.github.shanehd.utilities;

//TODO - Add detection for different linux systems / bit version
/**
 * Operating system identifierf
 * 
 * @author https://www.github.com/ShaneHD
 */
public enum OS {
	WINDOWS_95, WINDOWS_98, WINDOWS_2000, WINDOWS_XP, WINDOWS_VISTA, WINDOWS_7, WINDOWS_8, WINDOWS_8_1, WINDOWS_10, WINDOWS_UNKNOWN,
	LINUX,
	MAC,
	ANDROID,
	UNKNOWN;

	/** All Windows versions */ 
	public final static OS[] ALL_WINDOWS = {WINDOWS_95, WINDOWS_98, WINDOWS_2000, WINDOWS_XP, WINDOWS_VISTA, WINDOWS_7, WINDOWS_8, WINDOWS_8_1, WINDOWS_10, WINDOWS_UNKNOWN};
	/** All Linux versions */
	public final static OS[] ALL_LINUX =  {LINUX};
	/** All Macintosh versions */
	public final static OS[] ALL_MAC = {MAC};
	/** All operating systems (including unknown) */
	public final static OS[] ALL;
	/** All known operating systems */
	public final static OS[] ALL_KNOWN;

	static {
		OS[] all = OS.values();
		ALL = all;
		ALL_KNOWN = new OS[all.length - 2];
		
		for(int i = 0; i < ALL_KNOWN.length; i++)
			ALL_KNOWN[i] = all[i];
	}
	
	/**
	 * Find the {@link OS} of {@link #name}
	 * @param name A <code>System.getProperty("os.name");</code> value
	 */
	public static OS find(String name) {
		name = name.toLowerCase();
		
		if(name.contains("win")) {
			if(name.contains("7"))
				return WINDOWS_7;

			if(name.contains("8.1"))
				return WINDOWS_8_1;

			if(name.contains("8"))
				return WINDOWS_8;
			
			if(name.contains("10"))
				return WINDOWS_10;
			
			if(name.contains("xp"))
				return WINDOWS_XP;
			
			if(name.contains("vista"))
				return WINDOWS_VISTA;

			if(name.contains("95"))
				return WINDOWS_95;

			if(name.contains("98"))
				return WINDOWS_98;

			if(name.contains("2000"))
				return WINDOWS_2000;

			return WINDOWS_UNKNOWN;
		}
		
		if(name.contains("android"))
			return ANDROID;
		
		if(name.contains("linux"))
			return LINUX;
		
		if(name.contains("mac"))
			return MAC;
		
		return UNKNOWN;
	}
	
	public String getHomeDirectory() {
		return getHomeDirectory(System.getProperty("user.name"));
	}
	
	public String getHomeDirectory(String username) {
		switch(this) {
		case MAC:
			return "~/";
		}
		
		if(isWindows())
			return "C:/Users/" + username + "/Documents/";
		
		throw new RuntimeException("Can't find home directory in OS");
	}
	
	/**
	 * Check whether the current OS is compatible with another OS
	 */
	public boolean isCompatible(OS os) {
		if(isWindows())
			return os.isWindows();
		
		if(isLinux())
			return os.isLinux();
		
		if(isMac())
			return os.isMac();

		Log.get().warning("[" + getClass().getName() + "] I don't know if this is compatible or not: " + StringUtils.quote(os));
		return false;
	}
	
	public boolean isWindows() {
		return toString().contains("WINDOWS");
	}
	
	public boolean isWindows8() {
		return this == WINDOWS_8;
	}
	
	public boolean isMac() {
		return this == MAC;
	}
	
	public boolean isLinux() {
		return this == LINUX;
	}
	
	/**
	 * @return Whether the operating system is a computer or not (not a mobile device)
	 */
	public boolean isComputer() {
		return isWindows() || isLinux() || isMac();
	}
	
	/**
	 * For the current machine
	 * @see {@link #find(String)}
	 */
	public static OS current() {
		return find(System.getProperty("os.name"));
	}
}

