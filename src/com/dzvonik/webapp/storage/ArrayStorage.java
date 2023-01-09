package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                storage[i] = r;
            }
        }
    }

    public void save(Resume r) {
        if (size < storage.length) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("com.dzvonik.webapp.storage.ArrayStorage is overflow. Please, create a new storage");
        }
    }

    public Resume get(String uuid) {
        int index = exist(uuid);
        if (index != -1) {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        int index = exist(uuid);
        if (index != -1) {
            storage[index] = null;
            System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    public int size() {
        return size;
    }

    private int exist(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        System.out.println("Resume with uuid: " + uuid + " not found");
        return -1;
    }

}
