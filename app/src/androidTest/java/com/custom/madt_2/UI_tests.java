package com.custom.madt_2;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.anything;

@RunWith(AndroidJUnit4.class)
public class UI_tests {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    private void enterText(String input) {
        onView(withId(R.id.txt1)).perform(typeText(input), closeSoftKeyboard());
    }

    private void selectSpinnerItem(int position) {
        onView(withId(R.id.spn1)).perform(click());
        onData(anything()).atPosition(position).perform(click());
    }

    @Test
    public void countSentences() {
        enterText("Hello. How are you? Fine!");
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.tv1)).check(matches(withText("The count is 3")));
    }

    @Test
    public void countWords() {
        selectSpinnerItem(1);
        enterText("one two three");
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.tv1)).check(matches(withText("The count is 3")));
    }

    @Test
    public void countChars() {
        selectSpinnerItem(2);
        enterText("Hello");
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.tv1)).check(matches(withText("The count is 5")));
    }

    @Test
    public void countDigits() {
        selectSpinnerItem(3);
        enterText("abc123");
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.tv1)).check(matches(withText("The count is 3")));
    }
}