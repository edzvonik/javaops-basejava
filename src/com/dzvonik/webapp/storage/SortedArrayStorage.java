package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        System.arraycopy(storage, index + 1, storage, index, numMoved);
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        index = -index - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

    /**
        If exist - index of existing element
        If not exist - return (-(insertionPoint) - 1)
     */
    @Override
    protected int exist(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
