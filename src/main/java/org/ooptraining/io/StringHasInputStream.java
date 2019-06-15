package org.ooptraining.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StringHasInputStream extends HasInputStream<String> {
    public StringHasInputStream(final String source) {
        super(source);
    }

    @Override
    public InputStream inputStream() {
        return new ByteArrayInputStream(source.getBytes());
    }
}
