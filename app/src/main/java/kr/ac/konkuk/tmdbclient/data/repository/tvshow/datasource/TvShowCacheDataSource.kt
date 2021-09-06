package kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource

import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}