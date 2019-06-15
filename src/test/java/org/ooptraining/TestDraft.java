package org.ooptraining;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class TestDraft {

    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void test1(TimeUnit unit) {
        log.debug("{}", unit);
    }
}

@Slf4j
@Nested
@Execution(ExecutionMode.CONCURRENT)
class ConcurrentTest {
    private static int num = 0;

    @RepeatedTest(500)
    void t1() {
        num += 10;
    }

    @RepeatedTest(500)
    void t2() {
        num += 10;
    }

    @RepeatedTest(500)
    void t3() {
        num += 10;
    }

    @RepeatedTest(500)
    void t4() {
        num += 10;
    }

    @AfterAll
    static void print() {
        log.info("num : {}\n", num);
        assertThat(num).isEqualTo(20000);
    }
}

class Person {

}

class Joe extends Person {

}