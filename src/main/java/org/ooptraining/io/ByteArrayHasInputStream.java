package org.ooptraining.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteArrayHasInputStream extends HasInputStream<byte[]> {
    public ByteArrayHasInputStream(final byte[] body) {
        super(body);
    }

    @Override
    public InputStream inputStream() {
        return new ByteArrayInputStream(source);
    }
}
