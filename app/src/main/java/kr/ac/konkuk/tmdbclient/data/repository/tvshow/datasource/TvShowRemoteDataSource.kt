package kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource

import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShowList

import retrofit2.Response


interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}