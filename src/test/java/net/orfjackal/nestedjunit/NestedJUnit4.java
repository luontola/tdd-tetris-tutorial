/*
 * Copyright © 2009  Esko Luontola, www.orfjackal.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.orfjackal.nestedjunit;

import org.junit.Test;
import org.junit.runner.*;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.*;
import org.junit.runners.model.InitializationError;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Allows organizing JUnit 4 tests into member classes. This makes it possible
 * to write tests in a more Behaviour-Driven Development (BDD) style:
 * <pre><code>
 * &#64;RunWith(NestedJUnit4.class)
 * public class WerewolfTest extends Assert {
 *     public class Given_the_moon_is_full {
 *         &#64;Before public void When_you_walk_in_the_woods() {
 *             ...
 *         }
 *         &#64;Test public void Then_you_can_hear_werewolves_howling() {
 *             ...
 *         }
 *         &#64;Test public void Then_you_wish_you_had_a_silver_bullet() {
 *             ...
 *         }
 *     }
 *     public class Given_the_moon_is_not_full {
 *         &#64;Before public void When_you_walk_in_the_woods() {
 *             ...
 *         }
 *         &#64;Test public void Then_you_do_not_hear_any_werewolves() {
 *             ...
 *         }
 *         &#64;Test public void Then_you_are_not_afraid() {
 *             ...
 *         }
 *     }
 * }
 * </code></pre>
 *
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
