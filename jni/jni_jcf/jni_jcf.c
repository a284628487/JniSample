#include "jcf.h"
#include "jni.h"

// com.jni.jcf.JCF.getJCF

jint Java_com_jni_jcf_JCF_getJCF(JNIEnv* env, jclass clazz) {
	JNIJcf *j = GetJcf();
	jobject obj;
	return (*j)->GetGrade(j, obj);
}
