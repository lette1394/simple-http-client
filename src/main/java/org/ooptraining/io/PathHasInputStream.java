package org.ooptraining.io;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class PathHasInputStream extends HasInputStream<Path> {
    public PathHasInputStream(final Path body) {
        super(body);
    }

    @Override
    @SneakyThrows
    public InputStream inputStream() {
        return Files.newInputStream(source, StandardOpenOption.READ);
    }
}
