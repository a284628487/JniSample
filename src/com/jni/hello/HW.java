package com.jni.hello;

public class HW {

	public static native String getABI();
	
	static {
		System.loadLibrary("jni_hello");
	}
	
}
