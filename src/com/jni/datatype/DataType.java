package com.jni.datatype;

public class DataType {

	public native static void getValueFromJava(int intInput, String strInput, byte[] bts);
	
	static {
		System.loadLibrary("jni_datatype");
	}
}
