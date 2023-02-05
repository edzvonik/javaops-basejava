package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.exception.StorageException;
import com.dzvonik.webapp.model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

//    @Test
//    public void saveOverflow() throws StorageException {
//        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
//            storage.save(new Resume(""));
//        }
//
//        assertThrows(StorageException.class, () -> {
//            storage.save(new Resume("overflow resume"));
//        });
//    }

}