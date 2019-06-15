package org.ooptraining.util.test.extendwith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(AnimalSubclassTestExtension.class)
public class PersonTest {
    @InstanceForExtension
    public Person person;

    @BeforeEach
    void setUp() {
        person = new Person() {
            @Override
            public boolean isMarried() {
                return false;
            }
        };
    }

    @Test
    void personCanTalk() {
        final String actual = person.talk();
        final String expected = "블라블라";
        assertThat(actual).isEqualTo(expected);
    }
}
