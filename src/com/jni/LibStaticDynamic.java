package com.jni;

/**
 * ��̬��������̬��demo
 */
public class LibStaticDynamic {
	static {
		System.loadLibrary("dynamiclib");
	}

	public native int add(int x, int y);
}
