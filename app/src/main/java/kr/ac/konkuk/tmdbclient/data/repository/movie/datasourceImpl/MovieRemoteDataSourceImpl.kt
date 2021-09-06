package kr.ac.konkuk.tmdbclient.data.repository.movie.datasourceImpl

import kr.ac.konkuk.tmdbclient.data.api.TMDBService
import kr.ac.konkuk.tmdbclient.data.model.movie.MovieList
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
    // = -> { return }
}