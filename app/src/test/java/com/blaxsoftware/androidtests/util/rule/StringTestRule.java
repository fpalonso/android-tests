package com.blaxsoftware.androidtests.util.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A test rule intended to wrap each of the tests within a test class. What it does is just print
 * a message before and after each test.
 *
 * @author fpalonso
 */
public class StringTestRule implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println("This runs right before each test");
                base.evaluate();
                System.out.println("This runs right after each test");
            }
        };
    }
}
