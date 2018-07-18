LOCAL_PATH :=$(call my-dir)

#--------------------
include $(CLEAR_VARS)
LOCAL_LDLIBS	+= -llog
LOCAL_MODULE    := jni_datatype
LOCAL_SRC_FILES := datatype.c
include $(BUILD_SHARED_LIBRARY)
