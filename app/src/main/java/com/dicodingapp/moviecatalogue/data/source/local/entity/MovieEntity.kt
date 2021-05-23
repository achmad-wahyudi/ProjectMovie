package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moviesentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "tagLine")
    var tagLine: String,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double,

    @ColumnInfo(name = "posterPath")
    var posterPath: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String,

    @ColumnInfo(name = "budget")
    var budget: Int,

    @ColumnInfo(name = "revenue")
    var revenue: Int,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false,
)