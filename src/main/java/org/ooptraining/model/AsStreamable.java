package org.ooptraining.model;

import java.io.File;

// 종단 연산 (as 어쩌구)
public interface AsStreamable {
    // Optional 말고 Wrapper를 제공해서 exception-free 하게 작성해보자?
    File toFile(final String path);

    void toRelay();
}
