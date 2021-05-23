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

    @ColumnInfo(name = "air_date")
    var air_date: String,

    @ColumnInfo(name = "episodeNumber")
    var episodeNumber: String,

    @ColumnInfo(name = "lastId")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "seasonNumber")
    var seasonNumber: String,

    @ColumnInfo(name = "stillPath")
    var stillPath: String,
)