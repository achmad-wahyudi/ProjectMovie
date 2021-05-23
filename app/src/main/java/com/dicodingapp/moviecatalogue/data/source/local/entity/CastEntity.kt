package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "castentities",
    primaryKeys = ["movieId", "castId"],
    foreignKeys = [ForeignKey(
        entity = MovieEntity::class,
        parentColumns = ["movieId"],
        childColumns = ["movieId"]
    )],
    indices = [Index(value = ["castId"]),
        Index(value = ["movieId"])]
)
data class CastEntity(
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @NonNull
    @ColumnInfo(name = "castId")
    var castId: String,

    @NonNull
    @ColumnInfo(name = "name")
    var name: String,

    @NonNull
    @ColumnInfo(name = "character")
    var character: String,

    @NonNull
    @ColumnInfo(name = "profilePath")
    var profilePath: String
)