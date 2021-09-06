package kr.ac.konkuk.tmdbclient.data.repository.artist.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.ac.konkuk.tmdbclient.data.db.ArtistDao
import kr.ac.konkuk.tmdbclient.data.db.MovieDao
import kr.ac.konkuk.tmdbclient.data.model.artist.Artist
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao):ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}