#include <string.h>
#include <jni.h>
#include <jni_lib_gmath.h>
#include <jni_lib_static_gmath.h>

unsigned Java_com_jni_lib_Lib_getPower(JNIEnv* env, jclass clazz) {
	return gpower(12);
}

unsigned Java_com_jni_lib_Lib_getPower2(JNIEnv* env, jclass clazz) {
	return gpower2(8);
}
