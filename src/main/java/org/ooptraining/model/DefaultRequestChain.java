package org.ooptraining.model;

import java.io.File;

public class DefaultRequestChain implements RequestChain {
    private Headers headers;
    private Params params;
    private Cookies cookies;

    @Override
    public RequestChain with(final Headers headers) {
        return this;
    }

    @Override
    public RequestChain with(final Params params) {
        return this;
    }

    @Override
    public RequestChain with(final Cookies cookies) {
        return this;
    }

    @Override
    public Response execute() {
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
