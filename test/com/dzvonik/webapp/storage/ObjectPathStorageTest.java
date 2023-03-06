package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectPathStorageTest extends AbstractArrayStorageTest {

    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }

}