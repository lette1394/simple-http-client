package org.ooptraining.io;

import java.io.InputStream;

public class DefaultHasInputStream extends HasInputStream<InputStream> {
    public DefaultHasInputStream(final InputStream source) {
        super(source);
    }

    @Override
    public InputStream inputStream() {
        return source;
    }
}
