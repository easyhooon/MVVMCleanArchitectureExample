package kr.ac.konkuk.tmdbclient.data.repository.artist.datasourceImpl

import kr.ac.konkuk.tmdbclient.data.api.TMDBService
import kr.ac.konkuk.tmdbclient.data.model.artist.ArtistList
import kr.ac.konkuk.tmdbclient.data.model.movie.MovieList
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
):ArtistRemoteDataSource{
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
    // = -> { return }
}


