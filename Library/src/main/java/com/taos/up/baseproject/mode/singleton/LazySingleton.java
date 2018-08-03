package com.taos.up.baseproject.mode.singleton;

/**
 * Created by PrinceOfAndroid on 2018/7/27 0027.
 */

public class LazySingleton {
    // 1. 类加载时，先不自动创建单例
    //  即，将单例的引用先赋值为 Null
    private static LazySingleton singleton;

    private LazySingleton() {

    }

    //  需要时才手动调用 getInstance（） 创建 单例
    public static LazySingleton getInstance() {
        // 先判断单例是否为空，以避免重复创建
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }


    //  加入同步锁
    public static LazySingleton getSaveInstance() {
        /**
         * 每次访问都要进行线程同步（即 调用synchronized锁)，造成过多的同步开销（加锁 = 耗时、耗能）
         */
        synchronized (LazySingleton.class) {
            if (singleton == null) {
                singleton = new LazySingleton();
            }
            return singleton;
        }
    }

    // 双重校验锁  提高性能  若单例已创建，则不需再执行加锁操作就可获取实例
    public static LazySingleton getDoubbleCheckSaveInstance() {
        //加入同步锁
        /**
         * 实现复杂 = 多种判断，易出错
         */
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 单例创建时机可控，即有需要时，才 手动创建 单例
     * 基础实现的懒汉式是线程不安全的
     */

}
