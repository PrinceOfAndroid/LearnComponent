package com.taos.up.baseproject.mode.singleton;

/**
 * Created by PrinceOfAndroid on 2018/7/27 0027.
 * 饿汉式
 */

public class HungrySingleton {
    // 1. 加载该类时，单例就会自动被创建
    private static HungrySingleton singleton = new HungrySingleton();

    // 2. 构造函数 设置为 私有权限
    // 原因：禁止他人创建实例
    private HungrySingleton() {

    }

    // 3. 通过调用静态方法获得创建的单例
    public static HungrySingleton getInstance() {
        return singleton;
    }

    /**
     * 线程安全
     * JVM在类的初始化阶段(即 在Class被加载后、被线程使用前)，会执行类的初始化
     * 在执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化
     */

}
