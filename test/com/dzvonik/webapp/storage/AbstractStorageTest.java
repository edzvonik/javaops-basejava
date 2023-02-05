package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.exception.ExistStorageException;
import com.dzvonik.webapp.exception.NotExistStorageException;
import com.dzvonik.webapp.exception.StorageException;
import com.dzvonik.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractStorageTest {

    protected Resume[] resumes;
    protected Storage storage;

    {
        resumes = new Resume[4];
        for (int i = 0; i < resumes.length; i++) {
            resumes[i] = new Resume("uuid" + i);
        }
    }

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() throws ExistStorageException {
        storage.clear();
        for (int i = 0; i < resumes.length - 1; i++) {
            storage.save(resumes[i]);
        }
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws NotExistStorageException {
        Resume newResume = new Resume(resumes[0].getUuid());
        storage.update(newResume);
        assertTrue(newResume.equals(storage.get(resumes[0].getUuid())));
    }

    @Test
    public void updateNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
           storage.update(new Resume("dummy"));
        });
    }

    @Test
    public void getAll() {
        Resume[] resumesFromStorage = storage.getAll();
        assertEquals(resumes.length - 1, resumesFromStorage.length);
        assertEquals(resumes[0], resumesFromStorage[0]);
        assertEquals(resumes[1], resumesFromStorage[1]);
        assertEquals(resumes[2], resumesFromStorage[2]);
    }

    @Test
    public void save() {
        storage.save(resumes[3]);
        assertEquals(4, storage.size());
        assertEquals(resumes[3], storage.get("uuid3"));
    }

    @Test
    public void saveExist() throws ExistStorageException {
        assertThrows(ExistStorageException.class, () -> {
            storage.save(resumes[0]);
        });
    }

    @Test
    public void delete() throws NotExistStorageException {
        storage.delete("uuid1");
        assertEquals(2, storage.size());
        assertThrows(NotExistStorageException.class, () -> {
           storage.get("uuid1");
        });
    }

    @Test
    public void deleteNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.delete("uuid10");
        });
    }

    @Test
    public void get() {
        Resume resume = storage.get("uuid0");
        assertEquals(resumes[0], resume);
    }

    @Test
    public void getNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get("dummy");
        });
    }

}