package kr.ac.konkuk.tmdbclient.data.repository.movie.datasource

import kr.ac.konkuk.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}