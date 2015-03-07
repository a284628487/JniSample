#include "lib_static.h"
#include <jni.h>

jint Java_com_jni_LibStaticDynamic_add(JNIEnv* env, jobject thiz, jint x,
		jint y) {
	return add(x, y);
}
