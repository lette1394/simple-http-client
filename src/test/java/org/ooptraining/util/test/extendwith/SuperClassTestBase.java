package org.ooptraining.util.test.extendwith;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SuperClassTestBase<TEST_TARGET, TEST_CLASS> {
    private final Class<TEST_TARGET> testTarget;
    private final Class<TEST_CLASS> testClass;

    protected TEST_TARGET castToTestTarget(final Object object) {
        return testTarget.cast(object);
    }

    protected TEST_CLASS castToTestClass(final Object object) {
        return testClass.cast(object);
    }
}
