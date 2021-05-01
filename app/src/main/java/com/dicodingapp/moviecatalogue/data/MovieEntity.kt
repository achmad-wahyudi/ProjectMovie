package com.dicodingapp.moviecatalogue.data

data class MovieEntity(
    var genres: List<GenresEntity>,
    var movieId: String,
    var title: String,
    var releaseDate: String,
    var status: String,
    var tagLine: String,
    var voteAverage: Double,
    var posterPath: Int,
    var overview: String,
    var backdropPath: String,
    var casts: List<CastEntity>,
    var budget: Int,
    var revenue: Int,
)