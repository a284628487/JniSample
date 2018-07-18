#include "jni.h"

#ifndef HOPERUN1_JCF_H
#define HOPERUN1_JCF_H

struct _JNIJcf;
typedef const struct JNIJcfInterface* C_JNIJcf;

#if defined(__cplusplus)
typedef _JNIJcf JNIJcf;
#else
typedef const struct JNIJcfInterface* JNIJcf;
#endif

struct JNIJcfInterface {
    jint (*GetGrade)(JNIJcf*, jobject);
};

struct _JNIJcf {
    struct JNIJcfInterface* functions;

#if defined(__cplusplus)
    jint GetGrade(jobject obj) {
        return functions->GetGrade(this, obj);
    }
#endif

};

jint GetGrade(JNIJcf *jcf, jobject jobj) {
    return 27;
}

#if defined(__cplusplus)
JNIJcf* GetJcf() {
    struct _JNIJcf jcf;
    jcf.functions->GetGrade = GetGrade;
    return &jcf;
}
#else
JNIJcf* GetJcf() {
    struct JNIJcfInterface jcf;
    jcf.GetGrade = GetGrade;
    return (JNIJcf*)(&jcf);
}
#endif

#endif //HOPERUN1_JCF_H
