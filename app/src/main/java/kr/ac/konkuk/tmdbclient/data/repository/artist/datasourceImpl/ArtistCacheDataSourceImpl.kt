package kr.ac.konkuk.tmdbclient.data.repository.artist.datasourceImpl

import kr.ac.konkuk.tmdbclient.data.model.artist.Artist
import kr.ac.konkuk.tmdbclient.data.model.movie.Movie
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl:ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}