package kr.ac.konkuk.tmdbclient.data.repository.artist

import android.util.Log
import kr.ac.konkuk.tmdbclient.data.model.artist.Artist
import kr.ac.konkuk.tmdbclient.data.model.movie.Movie
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import kr.ac.konkuk.tmdbclient.domain.repository.ArtistRepository
import kr.ac.konkuk.tmdbclient.domain.repository.MovieRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI() : List<Artist> {
        lateinit var artistList:List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body != null) {
                artistList = body.artists
            }
        }
        catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist>{
        lateinit var artistList:List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }
        catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if(artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistList:List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }
        catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if(artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}