package com.shhatrat.boilerplatekkmvp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.shhatrat.boilerplatekkmvp.ui.MainActivity
import com.shhatrat.boilerplatekkmvp.ui.joke.JokeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class JokeActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(JokeActivity::class.java)

    @Test
    fun listGoesOverTheFold() {
        onView(withText("mock joke"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onDbClick(){
        onView(withId(R.id.getSavedJokeBtn))
            .perform(click())
            .check(matches(withText("mock db joke")))
    }
}