package com.dzvonik.webapp.storage;

import org.junit.jupiter.api.BeforeAll;

class SortedArrayStorageTest extends AbstractArrayStorageTest {

    @BeforeAll
    static void init() {
        storage = new SortedArrayStorage();
    }

}