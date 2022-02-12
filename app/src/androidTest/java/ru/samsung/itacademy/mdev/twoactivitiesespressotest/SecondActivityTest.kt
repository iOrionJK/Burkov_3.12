package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SecondActivityTest{
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private fun goToSecondActivity(){
        onView(withId(R.id.button_main)).perform(ViewActions.click())
    }

    @Test
    @Throws(Exception::class)
    fun secondActivityIsOpened() {
        onView(withId(R.id.editText_main)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun checkReplyButton() {
        goToSecondActivity()
        onView(withId(R.id.button_second)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun clickReplyButton() {
        goToSecondActivity()
        onView(withId(R.id.button_second)).perform(ViewActions.click())
    }

    private val sampleText = "Text 1"

    @Test
    @Throws(Exception::class)
    fun checkText() {
        onView(withId(R.id.editText_main)).perform(ViewActions.typeText(sampleText))
        goToSecondActivity()
        onView(withId(R.id.text_message)).check(matches(withText(sampleText)))
    }
}