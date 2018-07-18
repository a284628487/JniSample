LOCAL_PATH :=$(call my-dir)

#--------------------Camera
include $(CLEAR_VARS)
LOCAL_LDLIBS += -llog -ljnigraphics
LOCAL_MODULE    := jni_camerapro
LOCAL_SRC_FILES := camerapro.c
include $(BUILD_SHARED_LIBRARY)
