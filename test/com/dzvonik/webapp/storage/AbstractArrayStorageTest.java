package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.exception.ExistStorageException;
import com.dzvonik.webapp.exception.NotExistStorageException;
import com.dzvonik.webapp.exception.StorageException;
import com.dzvonik.webapp.model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    public void saveOverflow() throws Exception {
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume());
        }

        assertThrows(StorageException.class, () -> {
            storage.save(new Resume());
        });
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void update() {

    }

    @Test
    void save() {
        Resume newResume = new Resume();
        storage.save(newResume);
        assertEquals(newResume, storage.get(newResume.getUuid()));
    }

    @Test
    void saveIfExist() {
        assertThrows(ExistStorageException.class, () -> {
            storage.save(resumes[0]);
        });
    }

    @Test
    void delete() {
        storage.delete(resumes[1].getUuid());
        assertEquals(2, storage.size());
        assertThrows(NotExistStorageException.class, () -> {
            storage.get(resumes[1].getUuid());
        });
    }

    @Test
    void deleteIfNotExist() {
        Resume notExistResume = new Resume("uuid4");
        assertThrows(NotExistStorageException.class, () -> {
            storage.delete(notExistResume.getUuid());
        });
    }

    @Test
    void get() {
        Resume gettedResume = storage.get(resumes[0].getUuid());
        assertEquals(resumes[0], gettedResume);
    }

    @Test
    void getAll() {
        Resume[] allResumes = storage.getAll();
        assertArrayEquals(resumes, allResumes);
    }

    @Test
    void size() {
        assertEquals(resumes.length, storage.size());
    }

}