package com.jni.lib;

public class Lib {
	public static native int getPower();
	
	public static native int getPower2();
	
	static {
		System.loadLibrary("jni_invoker");
	}

}
