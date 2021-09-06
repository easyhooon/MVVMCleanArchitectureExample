package kr.ac.konkuk.tmdbclient.domain.usecase

import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShow
import kr.ac.konkuk.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository){
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}