#include <jni.h>
#include <stdio.h>
#include <android/log.h>

#ifndef eprintf
#define eprintf(...) __android_log_print(ANDROID_LOG_ERROR, "FileIO", __VA_ARGS__)
#endif

void Java_com_jni_io_IO_writeFile(JNIEnv* env, jobject thiz, jstring path,
		jstring content) {
	const char* filename = (*env)->GetStringUTFChars(env, path, NULL);
	const char* filecontent = (*env)->GetStringUTFChars(env, content, NULL);
	eprintf("writeFile#filename = %s", filename);
	eprintf("writeFile#fileContent = %s", filecontent);
	FILE* f = fopen(filename, "w");
	fprintf(f, filecontent);
	fclose(f);
}

void Java_com_jni_io_IO_appendFile(JNIEnv* env, jobject thiz, jstring path,
		jstring content) {
	const char* filename = (*env)->GetStringUTFChars(env, path, NULL);
	const char* filecontent = (*env)->GetStringUTFChars(env, content, NULL);
	FILE* f = fopen(filename, "a");
	fprintf(f, filecontent);
	fclose(f);
}
// https://www.jb51.net/article/71714.htm

jstring Java_com_jni_io_IO_readFile(JNIEnv* env, jobject thiz, jstring path) {
	const char* filename = (*env)->GetStringUTFChars(env, path, NULL);
	eprintf("readFile#filename = %s", filename);
	FILE* f = fopen(filename, "r");
	int len = fseek(f, 0, SEEK_END); // seek到文件末尾，获取文件大小
	eprintf("readFile#fseek.size = %d", len); // len 为 0?
	long size = ftell(f); // 获取文件大小
	char buf[size + 1];
	fseek(f, 0, SEEK_SET); // 回到文件开始
	fread(buf, sizeof(char), size, f);
	buf[size] = '\0';
	fclose(f);
	return (*env)->NewStringUTF(env, buf);
}
// https://www.cnblogs.com/a284628487/p/3720516.html
