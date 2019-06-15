package org.ooptraining.client;

import org.ooptraining.model.DefaultRequestChain;
import org.ooptraining.model.DefaultRequestChainWithBody;
import org.ooptraining.model.RequestChain;
import org.ooptraining.model.RequestChainWithBody;

public class SimpleHttpClient {
    public static RequestChain get(String url) {
        return new DefaultRequestChain();
    }

    // TODO: withBody interface 추가해서 Chaining 필요
    public static RequestChainWithBody post(String url) {
        return new DefaultRequestChainWithBody();
    }

    public static RequestChain put(String url) {
        return null;
    }

    public static RequestChain delete(String url) {
        return null;
    }
}