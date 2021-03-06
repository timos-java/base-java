package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveElement(Resume resume, int index) {
        int insertInStorage = -index - 1;
        System.arraycopy(storage, insertInStorage, storage, insertInStorage + 1, size - insertInStorage);
        storage[insertInStorage] = resume;
    }

    @Override
    protected void removeElement(int index) {
        int number = size - index - 1;
        if (number > 0) {
            System.arraycopy(storage, index + 1, storage, index, number);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
