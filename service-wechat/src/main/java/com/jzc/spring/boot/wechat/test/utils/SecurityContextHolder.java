package com.jzc.spring.boot.wechat.test.utils;

public class SecurityContextHolder {

    private static ThreadLocal<SecurityContext> sc = new ThreadLocal<>();

    public static void setSecurityContext(SecurityContext securityContext) {
        sc.set(securityContext);
    }

    public static SecurityContext get() {
        return sc.get();
    }

    public static void clearSecurityContext() {
        sc.remove();
    }

}
