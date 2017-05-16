package com.blaxsoftware.androidtests;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ServiceTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeoutException;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * @author fpalonso
 */
public class BoundServiceTest {

    @Rule
    public ServiceTestRule serviceRule = new ServiceTestRule();

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    @MediumTest
    public void boundService_startActivity() {
        try {
            BoundService.ServiceBinder binder = (BoundService.ServiceBinder) serviceRule
                    .bindService(new Intent(InstrumentationRegistry.getTargetContext(),
                            BoundService.class));

            binder.getService().startGreetingActivity();
            intended(hasComponent(GreetingActivity.class.getName()));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}