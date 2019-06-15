package org.ooptraining.model;

public interface AsParsable {
    // 종단 연산
    <T> T parseAs(final Class<T> type);
}
