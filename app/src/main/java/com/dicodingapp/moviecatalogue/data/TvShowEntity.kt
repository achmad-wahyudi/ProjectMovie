package com.dicodingapp.moviecatalogue.data

data class TvShowEntity(
    var createdBy: List<CreditCreatorEntity>,
    var firstAirDate: String,
    var genres: List<GenresEntity>,
    var tvShowId: String,
    var lastAirDate: String,
    var lastEpisodeToAir: TvShowLastEpisodeEntity,
    var name: String,
//    var nextEpisodeToAir: TvShowLastEpisodeEntity,
    var numberOfEpisodes: Int,
    var numberOfSeasons: Int,
    var overview: String,
    var status: String,
    var tagLine: String,
    var type: String,
    var voteAverage: String,
)