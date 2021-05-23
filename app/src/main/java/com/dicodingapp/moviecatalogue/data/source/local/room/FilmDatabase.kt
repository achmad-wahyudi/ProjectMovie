package com.dicodingapp.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicodingapp.moviecatalogue.data.source.local.entity.*

@Database(
    entities = [MovieEntity::class,
        TvShowEntity::class,
        GenresEntity::class,
        GenresTvShowEntity::class,
        CastEntity::class,
        CastTvShowEntity::class,
        TvShowLastEpisodeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao

    companion object {

        @Volatile
        private var INSTANCE: FilmDatabase? = null

        fun getInstance(context: Context): FilmDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    FilmDatabase::class.java,
                    "Films.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}