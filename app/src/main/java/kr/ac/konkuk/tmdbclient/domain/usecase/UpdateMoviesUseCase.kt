package kr.ac.konkuk.tmdbclient.domain.usecase

import kr.ac.konkuk.tmdbclient.data.model.movie.Movie
import kr.ac.konkuk.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}