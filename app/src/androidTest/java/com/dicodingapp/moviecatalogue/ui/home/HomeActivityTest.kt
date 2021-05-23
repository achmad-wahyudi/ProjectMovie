package com.dicodingapp.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.utils.Converting
import com.dicodingapp.moviecatalogue.utils.DataDummy
import com.dicodingapp.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyMovieGenres = DataDummy.generateDummyGenres()
    private val dummyTvShow = DataDummy.generateDummyTvShow()
    private val dummyTvShowGenres = DataDummy.generateDummyGenresTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

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
                1,
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

        val genres = dummyMovieGenres.joinToString { it.genreName }
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(genres)))
    }

    @Test
    fun setBookmarkMovie() {
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.img_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.img_bookmark)).perform(click())
        onView(withId(R.id.img_back)).perform(click())
        onView(withId(R.id.btn_bookmark_movie)).perform(click())

        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.img_back)).perform(click())
    }

    @Test
    fun deleteBookmarkMovie() {
        onView(withId(R.id.btn_bookmark_movie)).perform(click())

        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))

        onView(withId(R.id.img_bookmark)).perform(click())
        onView(withId(R.id.img_back)).perform(click())
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
                2,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].name)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyTvShow[0].firstAirDate)))
        onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_status)).check(matches(withText(dummyTvShow[0].status)))
        onView(withId(R.id.tv_tag_line)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tag_line)).check(matches(withText(dummyTvShow[0].tagLine)))
        onView(withId(R.id.tv_vote)).check(matches(isDisplayed()))
        val vote = (dummyTvShow[0].voteAverage * 10).toInt()
        onView(withId(R.id.tv_vote)).check(matches(withText("${vote}%")))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvShow[0].overview)))
        onView(withId(R.id.tv_number_of_episodes)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_number_of_episodes)).check(
            matches(
                withText(
                    Converting.formatNumber(dummyTvShow[0].numberOfEpisodes.toString())
                )
            )
        )
        onView(withId(R.id.tv_number_of_seasons)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_number_of_seasons)).check(
            matches(
                withText(
                    Converting.formatNumber(dummyTvShow[0].numberOfSeasons.toString())
                )
            )
        )

        val genres = dummyTvShowGenres.joinToString { it.genreName }
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(genres)))
    }

    @Test
    fun setBookmarkTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.img_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.img_bookmark)).perform(click())
        onView(withId(R.id.img_back)).perform(click())
        onView(withId(R.id.btn_bookmark_tv_show)).perform(click())

        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.img_back)).perform(click())
    }

    @Test
    fun deleteBookmarkTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_bookmark_tv_show)).perform(click())

        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))

        onView(withId(R.id.img_bookmark)).perform(click())
        onView(withId(R.id.img_back)).perform(click())
    }
}