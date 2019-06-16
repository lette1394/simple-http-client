package org.ooptraining.model;

public interface RequestChainWithBody extends RequestChain {
    RequestChainWithBody with(final Bodies bodies);
}
