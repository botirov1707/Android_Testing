package com.example.android_testing.activity

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.android_testing.test.R
import com.example.android_testing.utils.Utils
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest{
    private lateinit var  scenario: ActivityScenario<LoginActivity>

    @Before
    fun setup(){
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun loginWithValidCredentials() {

        // Type user name.
        onView(withId(com.example.android_testing.R.id.et_email))
            .perform(ViewActions.typeText(Utils.USER_NAME), ViewActions.closeSoftKeyboard())
        // Type valid password.
        onView(withId(com.example.android_testing.R.id.et_password))
            .perform(ViewActions.typeText(Utils.VALID_PASSWORD), ViewActions.closeSoftKeyboard())

        // Click the login button.
        onView(withId(com.example.android_testing.R.id.b_login)).perform(click())

        // Validate welcome string contains user name entered.
        onView(withId(com.example.android_testing.R.id.tv_message))
            .check(matches(withText(CoreMatchers.containsString(Utils.USER_NAME))))
    }
}