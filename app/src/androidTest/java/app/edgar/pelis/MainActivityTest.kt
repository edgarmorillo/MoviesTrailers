package app.edgar.pelis

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import app.edgar.pelis.ui.home.MainActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// Test Class testin UI

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @get:Rule
    var activityScenarioRule= androidx.test.ext.junit.rules.activityScenarioRule<MainActivity>()

    @Test
    fun checkActivityVisibility(){
        onView(withId(R.id.layout_mainActivity))
            .check((matches(isDisplayed())))
    }

    @Test
    fun checkViewVisibility(){
        onView(withId(R.id.viewPager))
            .check((matches(isDisplayed())))
    }

    @Test
    fun checkAppBarVisibility(){
        onView(withId(R.id.appBar))
            .check((matches(isDisplayed())))
    }

    @Test
    fun checkTabLayoutVisibility(){
        onView(withId(R.id.tabLayout))
            .check((matches(isDisplayed())))
    }

}