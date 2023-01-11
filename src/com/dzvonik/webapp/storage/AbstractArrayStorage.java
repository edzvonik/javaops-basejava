package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = exist(r.getUuid());
        if (index == -1) System.out.println("Resume not found!");
        storage[index] = r;
    }

    public void save(Resume r) {
        int index = exist(r.getUuid());
        if (index == -1 && size < storage.length) {
            storage[size] = r;
            size++;
        } else if (index != -1 && size == storage.length) {
            System.out.println("Storage is overflow. Please, create a new storage");
        } else if (index != -1) {
            System.out.println("Resume already exist in storage");
        }
    }

    public void delete(String uuid) {
        int index = exist(uuid);
        if (index != -1) {
            storage[index] = null;
            System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
            size--;
        } else {
            System.out.println("Resume with uuid: " + uuid + " not found");
        }
    }

    public Resume get(String uuid) {
        int index = exist(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Resume with uuid: " + uuid + " not found");
        return null;
    }

    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    public int size() {
        return size;
    }

    protected abstract int exist(String uuid);

}
