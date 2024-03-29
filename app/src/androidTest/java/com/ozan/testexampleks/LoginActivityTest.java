package com.ozan.testexampleks;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.ozan.testexampleks.helper.UserInfoUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule  = new ActivityTestRule<>(LoginActivity.class);

    private LoginActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void useDifferentUserNameFailedTest() throws Exception{

        assertNotNull(mActivity.findViewById(R.id.userName));
        assertNotNull(mActivity.findViewById(R.id.passwordEdit));
        assertNotNull(mActivity.findViewById(R.id.loginButton));

        onView(withId(R.id.userName)).perform(typeText(UserInfoUtil.EXAPLE_USER_FAKE_NAME), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.passwordEdit)).perform(typeText(UserInfoUtil.EXAMPLE_USER_PASSWORD), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());
        assertNotEquals(UserInfoUtil.EXAPLE_USER_FAKE_NAME,UserInfoUtil.EXAMPLE_USER_NAME);
    }

    @Test
    public void useDifferentUserPasswordFailedTest() throws Exception{
        assertNotNull(mActivity.findViewById(R.id.userName));
        assertNotNull(mActivity.findViewById(R.id.passwordEdit));
        assertNotNull(mActivity.findViewById(R.id.loginButton));

        onView(withId(R.id.userName)).perform(typeText(UserInfoUtil.EXAMPLE_USER_NAME),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.passwordEdit)).perform(typeText(UserInfoUtil.EXAPLE_USER_FAKE_PASSWORD),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());
        assertNotEquals(UserInfoUtil.EXAPLE_USER_FAKE_PASSWORD,UserInfoUtil.EXAMPLE_USER_PASSWORD);
    }

    @Test
    public void useRightPasswordAndNameSuccessTest() throws Exception{
        assertNotNull(mActivity.findViewById(R.id.userName));
        assertNotNull(mActivity.findViewById(R.id.passwordEdit));
        assertNotNull(mActivity.findViewById(R.id.loginButton));

        onView(withId(R.id.userName)).perform(typeText(UserInfoUtil.EXAMPLE_USER_NAME),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.passwordEdit)).perform(typeText(UserInfoUtil.EXAMPLE_USER_PASSWORD), ViewActions.closeSoftKeyboard());

        testLaunchOfMainActivityOnBottomClick();
        assertNotEquals(UserInfoUtil.EXAPLE_USER_FAKE_PASSWORD,UserInfoUtil.EXAMPLE_USER_PASSWORD);
    }


    public void testLaunchOfMainActivityOnBottomClick() throws Exception{

        assertNotNull(mActivity.findViewById(R.id.loginButton));

        onView(withId(R.id.loginButton)).perform(click());

        Activity mainActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(mainActivity);

        mainActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}