package kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasourceImpl

import kr.ac.konkuk.tmdbclient.data.api.TMDBService
import kr.ac.konkuk.tmdbclient.data.model.movie.MovieList
import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShowList
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
    // = -> { return }
}