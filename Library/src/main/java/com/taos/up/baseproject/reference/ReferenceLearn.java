package com.taos.up.baseproject.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceLearn {
    public static void main(String[] args) {
        /**
         * 强引用  oom时也不会进行回收
         */
        String s = new String("1111111");

        /**
         * 软引用 内存不足会进行回收
         */
        SoftReference<String> srfStr = new SoftReference<>(s);

        /**
         * 弱引用， JVM垃圾回收器发现了他就会进行回收
         */
        WeakReference<String> wrfStr = new WeakReference<>(s);

        /**
         * 虚引用  跟弱引用差不多，但是它被回收之前，会被放入ReferenceQueue中 需要ReferenceQueue
         */
        PhantomReference<String> ptrStr = new PhantomReference<>(s, new ReferenceQueue<String>());
    }
}

