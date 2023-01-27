package com.dzvonik.webapp.storage;

import org.junit.jupiter.api.BeforeAll;

class ArrayStorageTest extends AbstractArrayStorageTest {

    @BeforeAll
    static void init() {
        storage = new ArrayStorage();
    }

}