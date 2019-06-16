package org.ooptraining.model;

import lombok.RequiredArgsConstructor;
import org.ooptraining.model.pipeline.Pipeline;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequiredArgsConstructor
public class RawResponse<T> implements Response {
    private final InputStream in;

    @Override
    public <T> T parseAs(final Class<T> type) {
        return null;
    }

    @Override
    public Response then(final Pipeline pipeline) {
        return null;
    }

    @Override
    public File toFile(final String path) {
        try {
            return Files.createFile(Paths.get(path)).toFile();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void toRelay() {

    }

    @Override
    public <T> Response convert(final Class<T> type) {
        return null;
    }
}
