package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "genreentities",
    primaryKeys = ["movieId", "genreId"],
    foreignKeys = [ForeignKey(
        entity = MovieEntity::class,
        parentColumns = ["movieId"],
        childColumns = ["movieId"]
    )],
    indices = [Index(value = ["movieId"]),
        Index(value = ["genreId"])]
)
data class GenresEntity(
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @NonNull
    @ColumnInfo(name = "genreId")
    var genreId: String,

    @NonNull
    @ColumnInfo(name = "genreName")
    var genreName: String
)