package com.dicodingapp.moviecatalogue.data.source.remote.network.response

import com.google.gson.annotations.SerializedName

data class TvShowDetailResponse(

    @field:SerializedName("number_of_episodes")
    val numberOfEpisodes: Int? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("genres")
    val genres: List<GenresItem?>? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("number_of_seasons")
    val numberOfSeasons: Int? = null,

    @field:SerializedName("first_air_date")
    val firstAirDate: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("original_name")
    val originalName: String? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("tagline")
    val tagline: String? = null,

    @field:SerializedName("last_air_date")
    val lastAirDate: String? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("popularity")
    val popularity: Double? = null
)

data class LastEpisodeToAir(

    @field:SerializedName("air_date")
    val airDate: String? = null,

    @field:SerializedName("overview")
    val overview: String? = "",

    @field:SerializedName("episode_number")
    val episodeNumber: Int? = 0,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("season_number")
    val seasonNumber: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("still_path")
    val stillPath: String? = null,

    @field:SerializedName("vote_count")
    val voteCount: Int? = null
)
