/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import org.junit.Test;
import org.junit.runner.*;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.*;
import org.junit.runners.model.InitializationError;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Esko Luontola
 */
public class NestedJUnit4 extends ParentRunner<Runner> {

    private final List<Runner> children = new ArrayList<Runner>();

    public NestedJUnit4(Class<?> testClass) throws InitializationError {
        super(testClass);
        addToChildrenAllNestedClassesWithTests(testClass);
    }

    private void addToChildrenAllNestedClassesWithTests(Class<?> testClass) throws InitializationError {
        for (Class<?> child : (Class<?>[]) testClass.getDeclaredClasses()) {
            if (containsTests(child)) {
                children.add(new NestedJUnit4ClassRunner(child));
            }
        }
    }

    private boolean containsTests(Class<?> clazz) {
        for (Method method : clazz.getMethods()) {
            if (method.getAnnotation(Test.class) != null) {
                return true;
            }
        }
        return false;
    }

    protected List<Runner> getChildren() {
        return children;
    }

    protected Description describeChild(Runner child) {
        return child.getDescription();
    }

    protected void runChild(Runner child, RunNotifier notifier) {
        child.run(notifier);
    }


    private static class NestedJUnit4ClassRunner extends BlockJUnit4ClassRunner {

        public NestedJUnit4ClassRunner(Class<?> childClass) throws InitializationError {
            super(childClass);
        }

        protected void validateConstructor(List<Throwable> errors) {
            validateOnlyOneConstructor(errors);
            validateNonStaticInnerClassWithDefaultConstructor(errors);
        }

        private void validateNonStaticInnerClassWithDefaultConstructor(List<Throwable> errors) {
            try {
                getTestClass().getJavaClass().getConstructor(getParentClass());
            } catch (NoSuchMethodException e) {
                String gripe = "Nested test classes should be non-static and have a public zero-argument constructor";
                errors.add(new Exception(gripe));
            }
        }

        protected Object createTest() throws Exception {
            Object parent = getParentClass().newInstance();
            return getTestClass().getOnlyConstructor().newInstance(parent);
        }

        private Class<?> getParentClass() {
            return getTestClass().getJavaClass().getEnclosingClass();
        }
    }
}
