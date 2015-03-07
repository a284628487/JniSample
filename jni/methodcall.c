#include <string.h>
#include <jni.h>

jint Java_com_jni_MethodCall1_jniCalljavaMethod(JNIEnv* env, jobject thiz)
//env:��ǰ���̵߳�����,�����߳�ȫ���Ķ���;thiz:��ǰ���ʵ��,ָ.java�ļ�������
{
	jint si;
	jfieldID fid; // һ���ֶ�,ʵ���϶�Ӧjava�������һ���ֶλ�����;
	jclass cls = (*env)->GetObjectClass(env, thiz); // ��Ķ���ʵ��
	jmethodID mid = (*env)->GetStaticMethodID(env, cls, "javaMethod", "()V"); // һ��������id
	//(I)V  (I)I
	if (mid == NULL) {
		return -1;
	}
	(*env)->CallStaticVoidMethod(env, cls, mid); //����callback����
	fid = (*env)->GetStaticFieldID(env, cls, "value", "I"); //ȡ��si�ֶ�
	if (fid == NULL) {
		return -2;
	}
	si = (*env)->GetStaticIntField(env, cls, fid); //ȡ���ֶζ�Ӧ��ֵ(fid�ֶζ�Ӧ��ֵ)
	return si;
	//	return (*env)->NewStringUTF(env, "init success");
}
