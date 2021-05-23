package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MovieWithGenreAndCast(
    @Embedded
    var mMovie: MovieEntity,

    @Relation(parentColumn = "movieId", entityColumn = "movieId")
    var mGenres: List<GenresEntity>,

    @Relation(parentColumn = "movieId", entityColumn = "movieId")
    var mCast: List<CastEntity>
)