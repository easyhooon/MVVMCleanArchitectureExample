package kr.ac.konkuk.tmdbclient.domain.repository

import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}