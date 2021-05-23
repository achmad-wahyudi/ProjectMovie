package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "genretvshowentities",
    primaryKeys = ["tvShowId", "genreId"],
    foreignKeys = [ForeignKey(
        entity = TvShowEntity::class,
        parentColumns = ["tvShowId"],
        childColumns = ["tvShowId"]
    )],
    indices = [Index(value = ["genreId"]),
        Index(value = ["tvShowId"])]
)
data class GenresTvShowEntity(
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @NonNull
    @ColumnInfo(name = "genreId")
    var genreId: String,

    @NonNull
    @ColumnInfo(name = "genreName")
    var genreName: String
)