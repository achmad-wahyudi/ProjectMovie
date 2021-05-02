package com.dicodingapp.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.utils.Converting
import com.dicodingapp.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_status)).check(matches(withText(dummyMovie[0].status)))
        onView(withId(R.id.tv_tag_line)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tag_line)).check(matches(withText(dummyMovie[0].tagLine)))
        onView(withId(R.id.tv_vote)).check(matches(isDisplayed()))
        val vote = (dummyMovie[0].voteAverage * 10).toInt()
        onView(withId(R.id.tv_vote)).check(matches(withText("${vote}%")))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovie[0].overview)))
        onView(withId(R.id.tv_budget)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_budget)).check(
            matches(
                withText(
                    Converting.formatDollar(dummyMovie[0].budget.toString())
                )
            )
        )
        onView(withId(R.id.tv_revenue)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_revenue)).check(
            matches(
                withText(
                    Converting.formatDollar(dummyMovie[0].revenue.toString())
                )
            )
        )

        var genres = ""
        for (genresEntity in dummyMovie[0].genres) {
            genres += if (genres.isEmpty()) {
                genresEntity.genreName
            } else {
                ", ${genresEntity.genreName}"
            }
        }
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(genres)))

        onView(withId(R.id.rv_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_cast)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie[0].casts.size
            )
        )
    }

    @Test
    fun loadTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_tv)).check(matches(withText(dummyTvShow[0].name)))
        onView(withId(R.id.tv_date_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date_tv)).check(matches(withText(dummyTvShow[0].firstAirDate)))
        onView(withId(R.id.tv_status_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_status_tv)).check(matches(withText(dummyTvShow[0].status)))
        onView(withId(R.id.tv_tag_line_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tag_line_tv)).check(matches(withText(dummyTvShow[0].tagLine)))
        onView(withId(R.id.tv_vote_tv)).check(matches(isDisplayed()))
        val vote = (dummyTvShow[0].voteAverage * 10).toInt()
        onView(withId(R.id.tv_vote_tv)).check(matches(withText("${vote}%")))
        onView(withId(R.id.tv_overview_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_tv)).check(matches(withText(dummyTvShow[0].overview)))
        onView(withId(R.id.tv_number_of_episodes_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_number_of_episodes_tv)).check(
            matches(
                withText(
                    Converting.formatNumber(dummyTvShow[0].numberOfEpisodes.toString())
                )
            )
        )
        onView(withId(R.id.tv_number_of_seasons_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_number_of_seasons_tv)).check(
            matches(
                withText(
                    Converting.formatNumber(dummyTvShow[0].numberOfSeasons.toString())
                )
            )
        )

        var genres = ""
        for (genresEntity in dummyTvShow[0].genres) {
            genres += if (genres.isEmpty()) {
                genresEntity.genreName
            } else {
                ", ${genresEntity.genreName}"
            }
        }
        onView(withId(R.id.tv_genre_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_tv)).check(matches(withText(genres)))

        onView(withId(R.id.rv_cast_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_cast_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow[0].casts.size
            )
        )
    }
}