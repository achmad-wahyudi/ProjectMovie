package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "tvshowlastepisodeentities",
    primaryKeys = ["tvShowId", "lastId"],
    foreignKeys = [ForeignKey(
        entity = TvShowEntity::class,
        parentColumns = ["tvShowId"],
        childColumns = ["tvShowId"]
    )],
    indices = [Index(value = ["tvShowId"]),
        Index(value = ["lastId"])]
)
data class TvShowLastEpisodeEntity(

    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @NonNull
    @ColumnInfo(name = "air_date")
    var air_date: String,

    @NonNull
    @ColumnInfo(name = "episodeNumber")
    var episodeNumber: String,

    @NonNull
    @ColumnInfo(name = "lastId")
    var id: String,

    @NonNull
    @ColumnInfo(name = "name")
    var name: String,

    @NonNull
    @ColumnInfo(name = "overview")
    var overview: String,

    @NonNull
    @ColumnInfo(name = "seasonNumber")
    var seasonNumber: String,

    @NonNull
    @ColumnInfo(name = "stillPath")
    var stillPath: String,
)