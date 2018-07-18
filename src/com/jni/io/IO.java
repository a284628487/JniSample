package com.jni.io;

public class IO {

	public static native void writeFile(String path, String content);

	public static native void appendFile(String path, String content);

	public static native String readFile(String path);

	static {
		System.loadLibrary("jni_fileio");
	}
}
