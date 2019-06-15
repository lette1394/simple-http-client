package org.ooptraining.model;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.InputStream;

@RequiredArgsConstructor(staticName = "of")
public class InputStreamRequestChain implements RequestChainWithBody {
    private final InputStream in;
    private final RequestChain chain;

    @Override
    public RequestChainWithBody withBody(final InputStream body) {
        return null;
    }

    @Override
    public RequestChainWithBody withBody(final String body) {
        return null;
    }

    @Override
    public RequestChainWithBody withBody(final byte[] body) {
        return null;
    }

    @Override
    public RequestChainWithBody withBody(final File body) {
        return null;
    }

    @Override
    public RequestChain with(final Headers headers) {
        return null;
    }

    @Override
    public RequestChain with(final Params headers) {
        return null;
    }

    @Override
    public RequestChain with(final Cookies cookies) {
        return null;
    }

    @Override
    public <T> T parseAs(final Class<T> type) {
        return null;
    }

    @Override
    public File toFile(final String path) {
        return null;
    }

    @Override
    public void toRelay() {

    }
}
