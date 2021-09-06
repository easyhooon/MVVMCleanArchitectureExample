package kr.ac.konkuk.tmdbclient.data.repository.movie.datasource

import kr.ac.konkuk.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}