package ga.shane.utilities;

/**
 * An operating system identifier utility<br>
 * Contains consts for pretty much all known OS's
 * 
 * @author http://www.shane.ga
 */
public enum OS {
	WINDOWS_7, WINDOWS_8, WINDOWS_VISTA, WINDOWS_XP, WINDOWS_UNKNOWN, LINUX, MAC, ANDROID, UNKNOWN;
	
	/** All Windows versions */ 
	public final static OS[] ALL_WINDOWS = {WINDOWS_7, WINDOWS_8, WINDOWS_VISTA, WINDOWS_XP, WINDOWS_UNKNOWN};
	/** All Linux versions */
	public final static OS[] ALL_LINUX =  {LINUX};
	/** All Macintosh versions */
	public final static OS[] ALL_MAC = {MAC};
	/** All operating systems (including unknown) */
	public final static OS[] ALL;
	/** All known operating systems */
	public final static OS[] ALL_KNOWN;
	
	static {
		OS[] all = OS.class.getEnumConstants();
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
			
			if(name.contains("8"))
				return WINDOWS_8;
			
			if(name.contains("xp"))
				return WINDOWS_XP;
			
			if(name.contains("vista"))
				return WINDOWS_VISTA;
			
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
		switch(this) {
		case MAC:
			return "~/";
		}
		
		if(isWindows())
			return "C:/Users/" + System.getProperty("user.name") + "/";
		
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
		
		System.err.println("[OS] I don't know if this is compatible or not.");
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

