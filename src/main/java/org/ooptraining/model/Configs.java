package org.ooptraining.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "configs")
public class Configs {
    public Configs timeout(final int seconds) {
        return this;
    }

    public Configs timeout(final long millis) {
        return this;
    }
}
