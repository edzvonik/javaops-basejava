package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.Config;

public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }

}