package org.ooptraining.util.test.extendwith;

import org.junit.jupiter.api.extension.*;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class AnimalSubclassTestExtension extends SuperClassTestBase<Animal, AnimalTest> implements Extension, BeforeTestExecutionCallback {
    public AnimalSubclassTestExtension() {
        super(Animal.class, AnimalTest.class);
    }

    @Override
    public void beforeTestExecution(final ExtensionContext context) throws IllegalAccessException {
        final Object requiredTestInstance = context.getRequiredTestInstance();

        final List<Animal> targets = new ArrayList<>();
        final Field[] declaredFields = context.getRequiredTestClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(InstanceForExtension.class)) {
                field.setAccessible(true);
                final Object o = field.get(requiredTestInstance);
                final Animal animal = castToTestTarget(o);
                targets.add(animal);
            }
        }

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectPackage("com.example.mytests"),
                        selectClass(MyTestClass.class)
                )
                .filters(includeClassNamePatterns(".*Test"))
                .build();

        Launcher launcher = LauncherFactory.create();
        launcher.execute();
    }
}
