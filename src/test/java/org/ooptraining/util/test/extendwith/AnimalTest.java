package org.ooptraining.util.test.extendwith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimalTest {
    private Animal animal;

    @BeforeEach
    void before() {
        animal = new Animal();
    }

    @Test
    void canBreath() {
        final String actual = animal.breath();

        final String expected = "후하후하";
        assertThat(actual).isEqualTo(expected);
    }
}
