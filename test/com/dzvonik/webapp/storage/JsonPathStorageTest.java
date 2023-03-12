package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.storage.serializer.JsonStreamSerializer;

public class JsonPathStorageTest extends AbstractArrayStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer()));
    }

}