package com.blaxsoftware.androidtests;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * @author fpalonso
 */
public class GreetingActivityTest {

    @Rule
    public ActivityTestRule<GreetingActivity> mGreetingActivityRule = new ActivityTestRule<>
            (GreetingActivity.class);

    @Test
    @MediumTest
    public void greetButton_greets() {
        onView(withId(R.id.greeting)).check(matches(withText("")));
        onView(withId(R.id.username)).perform(typeText("Fer"));
        onView(withText("Greet")).perform(click());
        onView(withId(R.id.greeting)).check(matches(withText("Hey Fer, what's up")));
    }
}