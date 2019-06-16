package org.ooptraining.model;

public interface RequestChain extends AsParsable, AsStreamable {
    RequestChain with(final Headers headers);

    RequestChain with(final Params params);

    RequestChain with(final Cookies cookies);

    RequestChain with(final Configs configs);

    Response execute();
}
