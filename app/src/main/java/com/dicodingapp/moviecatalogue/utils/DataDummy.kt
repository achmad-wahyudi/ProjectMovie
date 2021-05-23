package com.dicodingapp.moviecatalogue.utils

import com.dicodingapp.moviecatalogue.data.source.local.entity.*
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.*

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        val listGenresEntity = ArrayList<GenresEntity>()
        listGenresEntity.add(GenresEntity("567189", "18", "Action"))
        listGenresEntity.add(GenresEntity("567189", "10749", "Adventure"))
        listGenresEntity.add(GenresEntity("567189", "10402", "Thriller"))
        listGenresEntity.add(GenresEntity("567189", "10402", "War"))

        val listCastEntity = ArrayList<CastEntity>()
        listCastEntity.add(
            CastEntity(
                "567189",
                "973667",
                "Rosa Salazar",
                "Alita",
                "/pc2tCeB99HtmrghAoPKksZkbzUU.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "567189",
                "Tom Clancy's Without Remorse",
                "2021-04-29",
                "Released",
                "",
                7.3,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                0,
                0
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                "88396",
                "2021-04-23",
                "The Falcon and the Winter Soldier",
                6,
                1,
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "Ended",
                "Honor the shield.",
                "Miniseries",
                7.9
            )
        )

        return tvShow
    }

    fun generateRemoteDummyMovie(): List<ResultsItem> {
        val resultsItem = ArrayList<ResultsItem>()
        val resultItem = ResultsItem(
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            "en",
            "Tom Clancy's Without Remorse",
            false,
            "Tom Clancy's Without Remorse",
            emptyList(),
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            "",
            "",
            5972.653,
            7.3,
            567189,
            false,
            726
        )
        resultsItem.add(resultItem)
        return resultsItem
    }

    fun generateRemoteDummyDetailMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            "en",
            "tt0499097",
            false,
            "Tom Clancy's Without Remorse",
            "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
            0,
            emptyList(),
            5972.653,
            emptyList(),
            567189,
            732,
            0,
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            "Tom Clancy's Without Remorse",
            109,
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            emptyList(),
            emptyList(),
            "2021-04-29",
            7.3,
            "",
            "",
            false,
            "",
            "Released",
        )
    }

    fun generateRemoteDummyTvShow(): List<ResultsItemTvShow> {
        val resultsItem = ArrayList<ResultsItemTvShow>()
        val resultItem = ResultsItemTvShow(
            "2021-03-19",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "",
            emptyList(),
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            emptyList(),
            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            "The Falcon and the Winter Soldier",
            0.0,
            7.9,
            "The Falcon and the Winter Soldier",
            88396,
            0
        )
        resultsItem.add(resultItem)
        return resultsItem
    }

    fun generateRemoteDummyDetailTvShow(): TvShowDetailResponse {
        val listGenresItem = ArrayList<GenresItem>()
        listGenresItem.add(
            GenresItem(
                "Sci-Fi & Fantasy",
                10765
            )
        )
        listGenresItem.add(
            GenresItem(
                "Action & Adventure",
                10759
            )
        )
        listGenresItem.add(
            GenresItem(
                "Drama",
                18
            )
        )
        listGenresItem.add(
            GenresItem(
                "War & Politics",
                10768
            )
        )

        val lastEpisodeToAir = LastEpisodeToAir(
            "2021-04-23",
            "As The Flag Smashers escalate their efforts, Sam and Bucky take action.",
            6,
            7.167,
            "One World, One People",
            1,
            2558743,
            "/qXxCqMP7aj3rGndhVfGUyyU6hyq.jpg",
            6
        )
        return TvShowDetailResponse(
            6,
            "tt0499097",
            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            listGenresItem,
            88396,
            1,
            "2021-03-19",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            lastEpisodeToAir,
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "The Falcon and the Winter Soldier",
            7.9,
            "The Falcon and the Winter Soldier",
            "Honor the shield.",
            "2021-04-23",
            "Ended",
        )
    }

    fun generateDummyGenres(): List<GenresEntity> {
        val listGenresEntity = ArrayList<GenresEntity>()
        listGenresEntity.add(GenresEntity("567189", "18", "Action"))
        listGenresEntity.add(GenresEntity("567189", "10749", "Adventure"))
        listGenresEntity.add(GenresEntity("567189", "10402", "Thriller"))
        listGenresEntity.add(GenresEntity("567189", "10402", "War"))

        return listGenresEntity
    }

    fun generateDummyCast(): List<CastEntity> {
        val listCastEntity = ArrayList<CastEntity>()
        listCastEntity.add(
            CastEntity(
                "567189",
                "973667",
                "Rosa Salazar",
                "Alita",
                "/pc2tCeB99HtmrghAoPKksZkbzUU.jpg"
            )
        )
        return listCastEntity
    }

    fun generateDummyGenresTvShow(): List<GenresTvShowEntity> {
        val listGenresEntity = ArrayList<GenresTvShowEntity>()
        listGenresEntity.add(GenresTvShowEntity("88396", "80", "Sci-Fi & Fantasy"))
        listGenresEntity.add(GenresTvShowEntity("88396", "18", "Action & Adventure"))
        listGenresEntity.add(GenresTvShowEntity("88396", "9648", "Drama"))
        listGenresEntity.add(GenresTvShowEntity("88396", "10759", "War & Politics"))

        return listGenresEntity
    }

    fun generateDummyCastTvShow(): List<CastTvShowEntity> {
        val listCastEntity = ArrayList<CastTvShowEntity>()
        listCastEntity.add(
            CastTvShowEntity(
                "567189",
                "973667",
                "Rosa Salazar",
                "Alita",
                "/pc2tCeB99HtmrghAoPKksZkbzUU.jpg"
            )
        )
        return listCastEntity
    }

    fun generateDummyTvShowLastEpisodeEntity(): TvShowLastEpisodeEntity {
        val tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "88396",
            "2021-04-23",
            "6",
            "2558743",
            "One World, One People",
            "As The Flag Smashers escalate their efforts, Sam and Bucky take action.",
            "1",
            "/qXxCqMP7aj3rGndhVfGUyyU6hyq.jpg",
        )
        return tvShowLastEpisodeEntity
    }

    fun generateDummyMovieWithGenreAndCast(movie: MovieEntity): MovieWithGenreAndCast {
        return MovieWithGenreAndCast(movie, generateDummyGenres(), generateDummyCast())
    }

    fun generateDummyTvShowWithGenreAndCastAndLastEpisode(tvShow: TvShowEntity): TvShowWithGenreAndCastAndLastEpisode {
        return TvShowWithGenreAndCastAndLastEpisode(
            tvShow,
            generateDummyGenresTvShow(),
            generateDummyCastTvShow(),
            generateDummyTvShowLastEpisodeEntity()
        )
    }
}