package kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource

import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}