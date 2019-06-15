package org.ooptraining.model;

// streaming을 위해서 XXXstream을 저장해두고, 호출메서드에 따라 전략을 다르게 하자.
public interface Response extends AsParsable, AsStreamable {
    <T> Response convert(Class<T> type);
}
