package com.dzvonik.webapp.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super(uuid);
    }

}
