LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
# 添加.h目录
LOCAL_C_INCLUDES += $(LOCAL_PATH)/../jni_lib_shared
LOCAL_C_INCLUDES += $(LOCAL_PATH)/../jni_lib_static
# 依赖动态库，如有多个以空格隔开
LOCAL_SHARED_LIBRARIES :=libjni_lib_gmath
# 依赖静态库，如有多个以空格隔开
LOCAL_STATIC_LIBRARIES :=libjni_lib_static_gmath
LOCAL_LDLIBS    += -llog
LOCAL_MODULE    :=jni_invoker
LOCAL_SRC_FILES :=invoker.c
include $(BUILD_SHARED_LIBRARY)
