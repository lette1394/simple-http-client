package org.ooptraining.model;

public class DefaultRequestChainWithBody extends DefaultRequestChain implements RequestChainWithBody {
    private Bodies bodies;

    @Override
    public RequestChainWithBody with(final Bodies bodies) {
        return this;
    }
}
