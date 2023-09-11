package com.demussong.patterndesign.singleton;

/**
 * @author demussong
 * @describe
 * @date 2023/9/6 23:07
 */
public class Singleton {
    private Singleton() {}
    private static volatile Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

enum Singleton2{
    SINGLETON_2;
}

class Singleton3{
    private Singleton3(){}

    private static Singleton3 singleton3 = new Singleton3();

    public static Singleton3 getSingleton3() {
        return singleton3;
    }
}

// 不能保证线程安全
class Singleton4{
    private Singleton4(){}

    private static Singleton4 singleton4;

    public static Singleton4 getSingleton4() {
        if (singleton4 == null) {
            singleton4 = new Singleton4();
        }
        return singleton4;
    }
}

class Singleton5{
    private Singleton5(){}

    public static Singleton5 getSingleton5() {
        return InnerClass.singleton5;
    }

    static class InnerClass{
        private static Singleton5 singleton5 = new Singleton5();
    }
}
