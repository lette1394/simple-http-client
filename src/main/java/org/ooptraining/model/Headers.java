package org.ooptraining.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "headers")
public class Headers {
    public Headers add(final String key, final String value) {
        return this;
    }
}
