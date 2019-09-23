package com.ozan.testexampleks;

import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mMainActivity = null;

    @Before
    public void setUp() throws Exception {

        mMainActivity = activityTestRule.getActivity();
    }

    @Test
    public void notWorkingAnimationTest(){
        onView(withId(R.id.mainTextView)).check(matches(isDisplayed()));        //Textview gosterildi  mi ?
    }


    @After
    public void tearDown() throws Exception {
        mMainActivity = null;
    }
}