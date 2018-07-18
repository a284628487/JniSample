LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    :=jni_lib_static_gmath
# 多个文件以可以以空格隔开
LOCAL_SRC_FILES :=libjni_lib_static_gmath.a
include $(PREBUILT_STATIC_LIBRARY)

# -------------------编译静态库
#include $(CLEAR_VARS)
#LOCAL_MODULE    :=jni_lib_static_gmath
#LOCAL_SRC_FILES :=jni_lib_static_gmath.c
#include $(BUILD_STATIC_LIBRARY)
# 生成静态库，需要在 Application.mk 中指定 APP_MODULES，值同本文件中的 LOCAL_MODULE。
# 生成的文件在 obj/local 目录下。

# https://blog.csdn.net/u012702039/article/details/39156363
# http://topmanopensource.iteye.com/blog/1752490