package com.dicodingapp.moviecatalogue.ui.tv_show

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val tvShowEntities = viewModel.getTvShow()
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(10, tvShowEntities.size)
    }
}