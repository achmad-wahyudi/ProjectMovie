package com.dicodingapp.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "casttvshowentities",
    primaryKeys = ["tvShowId", "castId"],
    foreignKeys = [ForeignKey(
        entity = TvShowEntity::class,
        parentColumns = ["tvShowId"],
        childColumns = ["tvShowId"]
    )],
    indices = [Index(value = ["castId"]),
        Index(value = ["tvShowId"])]
)
data class CastTvShowEntity(
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

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