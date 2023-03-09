package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractArrayStorageTest {

    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }

}