package org.ooptraining.model;

import lombok.RequiredArgsConstructor;
import org.ooptraining.io.*;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(staticName = "bodies")
public class Bodies {
    private final List<HasInputStream<?>> bodies = new ArrayList<>();

    public Bodies add(final InputStream body) {
        append(new DefaultHasInputStream(body));
        return this;
    }

    public Bodies add(final String body) {
        append(new StringHasInputStream(body));
        return this;
    }

    public Bodies add(final byte[] body) {
        append(new ByteArrayHasInputStream(body));
        return this;
    }

    public Bodies add(final Path body) {
        append(new PathHasInputStream(body));
        return this;
    }

    public List<InputStream> inputStreams() {
        return bodies.stream()
                .map(HasInputStream::inputStream)
                .collect(Collectors.toList());
    }

    private void append(final HasInputStream<?> inputStream) {
        bodies.add(inputStream);
    }
}
