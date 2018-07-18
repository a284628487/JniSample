#include <android/log.h>
#include "jni_lib_static_gmath.h"

#if defined(__GNUC__) && __GNUC__ >= 4
#define GMATH_EXPORT __attribute__((visibility("default")))
#elif defined(__SUNPRO_C) && (__SUNPRO_C >= 0x590)
#define GMATH_EXPORT __attribute__((visibility("default")))
#else
#define GMATH_EXPORT
#endif

#define LOGE(...) \
  ((void)__android_log_print(ANDROID_LOG_ERROR, "jni_lib_gmath::", __VA_ARGS__))

/*
 * return 2 ^ n with multiplication implementation
 */
GMATH_EXPORT unsigned gpower2(unsigned n) {
    if (n == 0)
        return 1;
    if (n > 31) {
        LOGE("error from power(%d): integer overflow", n);
        return 0;
    }
    unsigned val = gpower2(n>>1) * gpower2 (n>>1);
    if (n & 1)
      val *= 2;
    return val;
}

