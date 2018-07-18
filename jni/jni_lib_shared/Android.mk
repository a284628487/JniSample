LOCAL_PATH := $(call my-dir)

#include $(CLEAR_VARS)
#LOCAL_LDLIBS    += -llog 
#LOCAL_MODULE    :=jni_lib_gmath
#LOCAL_SRC_FILES :=jni_lib_gmath.c
#include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    :=jni_lib_gmath
LOCAL_SRC_FILES :=libjni_lib_gmath.so
include $(PREBUILT_SHARED_LIBRARY)
# PREBUILT_SHARED_LIBRARY 的时候，LOCAL_SRC_FILES 必须为一个.so库
