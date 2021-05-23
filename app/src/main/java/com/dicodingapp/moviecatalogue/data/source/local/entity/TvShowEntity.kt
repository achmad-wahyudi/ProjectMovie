package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowsentities")
data class TvShowEntity(
    @NonNull
    @ColumnInfo(name = "backdropPath")
    var backdropPath: String,

    @NonNull
    @ColumnInfo(name = "firstAirDate")
    var firstAirDate: String,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @NonNull
    @ColumnInfo(name = "lastAirDate")
    var lastAirDate: String,

    @NonNull
    @ColumnInfo(name = "name")
    var name: String,

    @NonNull
    @ColumnInfo(name = "numberOfEpisodes")
    var numberOfEpisodes: Int,

    @NonNull
    @ColumnInfo(name = "numberOfSeasons")
    var numberOfSeasons: Int,

    @NonNull
    @ColumnInfo(name = "overview")
    var overview: String,

    @NonNull
    @ColumnInfo(name = "posterPath")
    var posterPath: String,

    @NonNull
    @ColumnInfo(name = "status")
    var status: String,

    @NonNull
    @ColumnInfo(name = "tagLine")
    var tagLine: String,

    @NonNull
    @ColumnInfo(name = "type")
    var type: String,

    @NonNull
    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false,
)