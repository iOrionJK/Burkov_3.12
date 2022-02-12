package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun checkInputBoxMain() {
        onView(withId(R.id.editText_main)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun checkSendButton() {
        onView(withId(R.id.button_main)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun clickSendButton() {
        onView(withId(R.id.button_main)).perform(click())
    }

    private val sampleText = "Second Text"

    @Test
    @Throws(Exception::class)
    fun checkTextReply() {
        onView(withId(R.id.button_main)).perform(click())
        onView(withId(R.id.editText_second)).perform(ViewActions.typeText(sampleText))
        onView(withId(R.id.button_second)).perform(click())
        onView(withId(R.id.text_message_reply)).check(matches(ViewMatchers.withText(sampleText)))
    }

}
