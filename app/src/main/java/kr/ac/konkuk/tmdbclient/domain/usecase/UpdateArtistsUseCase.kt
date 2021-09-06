package kr.ac.konkuk.tmdbclient.domain.usecase

import kr.ac.konkuk.tmdbclient.data.model.artist.Artist
import kr.ac.konkuk.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}