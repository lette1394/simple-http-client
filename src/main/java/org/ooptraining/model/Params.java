package org.ooptraining.model;

import lombok.RequiredArgsConstructor;


// TODO: queryString이 더 직관적인가? params가 더 나은가?
@RequiredArgsConstructor(staticName = "params")
public class Params {
    public Params add(final String key, final String value) {
        return this;
    }
}
