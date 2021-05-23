package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.LastEpisodeToAir

data class TvShowWithGenreAndCastAndLastEpisode(
    @Embedded
    var mTvShow: TvShowEntity,

    @Relation(parentColumn = "tvShowId", entityColumn = "tvShowId")
    var mGenresTvShow: List<GenresTvShowEntity>,

    @Relation(parentColumn = "tvShowId", entityColumn = "tvShowId")
    var mCastTvShow: List<CastTvShowEntity>,

    @Relation(parentColumn = "tvShowId", entityColumn = "tvShowId")
    var mLastEpisode: TvShowLastEpisodeEntity?
)