package com.jni.bitmap;

import android.graphics.Bitmap;

public class Bmp {

	public static native void huidu(Bitmap bmp);
	
	static {
		System.loadLibrary("jni_bmp");
	}
}
