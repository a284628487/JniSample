package com.jni;

/**
 * ¶¯Ì¬¿âÒÀÀµ±íÌ¬¿âdemo
 */
public class LibStaticDynamic {
	static {
		System.loadLibrary("dynamiclib");
	}

	public native int add(int x, int y);
}
