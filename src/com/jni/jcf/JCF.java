package com.jni.jcf;

public class JCF {

	public static native int getJCF();
	
	static {
		System.loadLibrary("jni_jcf");
	}
}
