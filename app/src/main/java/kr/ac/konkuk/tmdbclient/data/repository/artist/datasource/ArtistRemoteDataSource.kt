package kr.ac.konkuk.tmdbclient.data.repository.artist.datasource

import kr.ac.konkuk.tmdbclient.data.model.artist.ArtistList
import kr.ac.konkuk.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}