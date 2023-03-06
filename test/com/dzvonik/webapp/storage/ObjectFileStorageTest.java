package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectFileStorageTest extends AbstractArrayStorageTest {

    public ObjectFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }

}