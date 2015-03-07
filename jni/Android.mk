LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := helloworld
LOCAL_SRC_FILES := helloworld.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := methodcall
LOCAL_SRC_FILES := methodcall.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := methodcall1
LOCAL_SRC_FILES := methodcall.c
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := dynamicregistermethod
LOCAL_SRC_FILES := dynamicRegisterMethod.c
include $(BUILD_SHARED_LIBRARY)

# BUILD_STATIC_LIBRARY --> BUILD_SHARED_LIBRARY
# first lib, which will be build statically 
include $(CLEAR_VARS)
LOCAL_MODULE    := staticlib
LOCAL_SRC_FILES := lib_static.c
include $(BUILD_STATIC_LIBRARY)
# second lib, which will depend on and include the first one
include $(CLEAR_VARS)
LOCAL_MODULE    := dynamiclib
LOCAL_SRC_FILES := lib_dynamic.c
LOCAL_STATIC_LIBRARIES := staticlib
include $(BUILD_SHARED_LIBRARY)



