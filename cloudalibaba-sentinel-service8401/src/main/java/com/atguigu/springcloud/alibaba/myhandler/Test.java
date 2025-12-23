package com.atguigu.springcloud.alibaba.myhandler;

import io.netty.util.concurrent.CompleteFuture;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {

    static ThreadLocal<String> stringThreadLocal=new ThreadLocal<>();
    static ThreadLocal<Integer> integerThreadLocal=new ThreadLocal<>();


    public static void main(String[] args) throws Exception {

        integerThreadLocal.set(10);
        stringThreadLocal.set("hello");


        integerThreadLocal.get();

//        Class<Thread> threadClass = Thread.class;
//        Field threadLocals = threadClass.getDeclaredField("threadLocals");
//        threadLocals.setAccessible(true);
//        System.out.println(threadLocals);

        testCall(new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        });
        test();
    }


    public static void test(){
        System.out.println(handler("str", s -> s + "hello"));
    }

    //处理字符串
    public static String handler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    public static void testCall(Supplier<String> callable) throws Exception {
    }
}
