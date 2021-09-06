package kr.ac.konkuk.tmdbclient.data.repository.artist.datasource

import kr.ac.konkuk.tmdbclient.data.model.artist.Artist
import kr.ac.konkuk.tmdbclient.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}