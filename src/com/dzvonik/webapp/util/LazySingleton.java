package com.dzvonik.webapp.util;

public final class LazySingleton {

    private static final LazySingleton INSTANCE = new LazySingleton();

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        return INSTANCE;
    }

}
