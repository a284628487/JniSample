LOCAL_PATH :=$(call my-dir)

#--------------------IO
include $(CLEAR_VARS)
LOCAL_LDLIBS	+= -llog
LOCAL_MODULE    := jni_fileio
LOCAL_SRC_FILES := fileio.c
include $(BUILD_SHARED_LIBRARY)
