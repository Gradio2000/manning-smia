package com.optimagrowth.license.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserContextHolder {

    private static final ThreadLocal<UserContext> THREAD_LOCAL = new ThreadLocal<>();

    public static UserContext createEmptyContext(){
        return new UserContext();
    }

    public static UserContext getContext(){
        UserContext context = THREAD_LOCAL.get();
        if (context == null) {
            context = createEmptyContext();
            THREAD_LOCAL.set(context);
        }
        return context;
    }

    public static void setContext(UserContext context) {
        Assert.notNull(context, "Only non-null UserContext instances are permitted");
        THREAD_LOCAL.set(context);
    }
}
