package com.dicodingapp.moviecatalogue

import com.dicodingapp.moviecatalogue.data.source.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiService

object Injection {
    fun provideRepository(apiService: ApiService): FilmRepository {

        val remoteDataSource = RemoteDataSource.getInstance(apiService)

        return FilmRepository.getInstance(remoteDataSource)
    }
}