package kr.ac.konkuk.tmdbclient.domain.repository

import kr.ac.konkuk.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}