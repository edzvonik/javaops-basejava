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

    public void update(Resume resume) {
        int index = exist(resume.getUuid());
        if (index < 0) {
            System.out.println("Resume not found!");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        int index = exist(resume.getUuid());
        if (index >= 0) {
            System.out.println("Resume " + resume.getUuid() + " already exist");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage is overflow");
        } else {
            insertElement(resume, index);
            size++;
        }
    };

    public void delete(String uuid) {
        int index = exist(uuid);
        if (index < 0) {
            System.out.println("Resume with uuid: " + uuid + " not found");
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
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

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract int exist(String uuid);

}
