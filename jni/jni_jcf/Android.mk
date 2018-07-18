LOCAL_PATH :=$(call my-dir)

#--------------------HelloWorld
include $(CLEAR_VARS)
LOCAL_MODULE    := jni_jcf
# 多个文件以 \ 结尾并换行添加，也可以以空格隔开。
LOCAL_SRC_FILES := jcf.h jni_jcf.c
include $(BUILD_SHARED_LIBRARY)
