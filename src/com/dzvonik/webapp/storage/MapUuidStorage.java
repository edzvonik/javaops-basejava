package com.dzvonik.webapp.storage;

import com.dzvonik.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey((String) uuid);
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected Resume doGet(String uuid) {
        return map.get((String) uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove((String) uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}