package com.dzvonik.webapp.util;

public final class LazySingleton {

    volatile private static LazySingleton INSTANCE;

    double sin = Math.sin(13.);

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    // volatile гарантирует то, что ссылка на объект не будет присвоена без инициализации переменной sin
                    // reordering - запрещен, когда есть volatile
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }

}
