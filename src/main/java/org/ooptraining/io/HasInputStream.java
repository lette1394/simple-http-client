package org.ooptraining.io;

import lombok.RequiredArgsConstructor;

import java.io.InputStream;

@RequiredArgsConstructor
public abstract class HasInputStream<T> {
    protected final T source;

    public abstract InputStream inputStream();
}