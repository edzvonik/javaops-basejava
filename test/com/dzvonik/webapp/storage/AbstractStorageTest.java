package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractStorageTest {

    protected Resume[] resumes;
    protected Storage storage;

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void prepare() {
        storage.clear();
        resumes = new Resume[3];
        for (int i = 0; i < resumes.length; i++) {
            resumes[i] = new Resume("uuid" + i);
            storage.save(resumes[i]);
        }
    }

}