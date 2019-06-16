package org.ooptraining.model;

// streaming을 위해서 XXXstream을 저장해두고, 호출메서드에 따라 전략을 다르게 하자.
// 한번 inpustream에서 읽은 거는 메모리에 올려두자
// header나 params같은거는 불변식으로 사용하자.

public interface Response extends AsParsable, AsStreamable, Thenable {

}
