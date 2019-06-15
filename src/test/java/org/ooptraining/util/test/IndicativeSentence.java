package org.ooptraining.util.test;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class IndicativeSentence extends DisplayNameGenerator.ReplaceUnderscores {
    @Override
    public String generateDisplayNameForClass(final Class<?> testClass) {
        return super.generateDisplayNameForClass(testClass);
    }

    @Override
    public String generateDisplayNameForNestedClass(final Class<?> nestedClass) {
        return super.generateDisplayNameForNestedClass(nestedClass) + "...";
    }

    @Override
    public String generateDisplayNameForMethod(final Class<?> testClass, final Method testMethod) {
        return super.generateDisplayNameForMethod(testClass, testMethod).replace("()", "");
    }
}
