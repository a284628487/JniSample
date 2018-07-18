LOCAL_PATH :=$(call my-dir)

#--------------------Bitmap
include $(CLEAR_VARS)
LOCAL_LDLIBS += -llog -ljnigraphics
LOCAL_MODULE    := jni_bmp
LOCAL_SRC_FILES := bmp.c
include $(BUILD_SHARED_LIBRARY)
