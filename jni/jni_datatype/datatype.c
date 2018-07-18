#include <jni.h>
#include <stdio.h>
#include <android/log.h>

#ifndef eprintf
#define eprintf(...) __android_log_print(ANDROID_LOG_ERROR, "DataType", __VA_ARGS__)
#endif

void Java_com_jni_datatype_DataType_getValueFromJava(JNIEnv *env, jobject thiz,
		jint intValue, jstring strValue, jbyteArray bytesValue) {
	// jint / int
	eprintf("getValueFromJava: int = %d", intValue);
	// jstring 需要转换成 char*，才是真正的字符串。
	const char* strValue_ = (*env)->GetStringUTFChars(env, strValue, NULL);
	eprintf("getValueFromJava: string = %s", strValue_);
	// jbyteArray
	jbyte* bts = (*env)->GetByteArrayElements(env, bytesValue, NULL);
	eprintf("getValueFromJava: byte0 = %d", bts[0]);
	// 改变 bts 数组的值
	bts[0] = bts[0] + 20;
	jsize size = (*env)->GetArrayLength(env, bytesValue); // jsize = jint
	// 重新设置bytesValue
	(*env)->SetByteArrayRegion(env, bytesValue, 0, size, bts);
}

