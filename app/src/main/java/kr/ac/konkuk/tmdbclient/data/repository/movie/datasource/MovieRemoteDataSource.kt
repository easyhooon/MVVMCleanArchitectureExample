package kr.ac.konkuk.tmdbclient.data.repository.movie.datasource

import kr.ac.konkuk.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():  Response<MovieList>
}