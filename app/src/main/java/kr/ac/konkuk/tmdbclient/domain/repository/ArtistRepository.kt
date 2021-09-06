package kr.ac.konkuk.tmdbclient.domain.repository

import kr.ac.konkuk.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}