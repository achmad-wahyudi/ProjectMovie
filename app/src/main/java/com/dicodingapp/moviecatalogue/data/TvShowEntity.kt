package com.dicodingapp.moviecatalogue.data

data class TvShowEntity(
    var backdropPath: String,
    var firstAirDate: String,
    var genres: List<GenresEntity>,
    var tvShowId: String,
    var lastAirDate: String,
    var lastEpisodeToAir: TvShowLastEpisodeEntity,
    var name: String,
    var numberOfEpisodes: Int,
    var numberOfSeasons: Int,
    var overview: String,
    var posterPath: String,
    var status: String,
    var tagLine: String,
    var type: String,
    var voteAverage: Double,
    var casts: List<CastEntity>,
)