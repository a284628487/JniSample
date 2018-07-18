LOCAL_PATH :=$(call my-dir)

#--------------------Camera
include $(CLEAR_VARS)
LOCAL_LDLIBS += -llog -ljnigraphics
LOCAL_MODULE    := gpuimage
LOCAL_SRC_FILES := yuv-decoder.c
include $(BUILD_SHARED_LIBRARY)
