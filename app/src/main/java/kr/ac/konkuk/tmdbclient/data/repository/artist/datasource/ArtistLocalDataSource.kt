package kr.ac.konkuk.tmdbclient.data.repository.artist.datasource

import kr.ac.konkuk.tmdbclient.data.model.artist.Artist
import kr.ac.konkuk.tmdbclient.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}