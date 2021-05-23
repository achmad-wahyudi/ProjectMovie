package com.dicodingapp.moviecatalogue

import android.content.Context
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.LocalDataSource
import com.dicodingapp.moviecatalogue.data.source.local.room.FilmDatabase
import com.dicodingapp.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiService
import com.dicodingapp.moviecatalogue.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context, apiService: ApiService): FilmRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(apiService)
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()
        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}