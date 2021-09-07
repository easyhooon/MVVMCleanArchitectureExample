package kr.ac.konkuk.tmdbclient.presentation.di

import kr.ac.konkuk.tmdbclient.presentation.di.artist.ArtistSubComponent
import kr.ac.konkuk.tmdbclient.presentation.di.movie.MovieSubComponent
import kr.ac.konkuk.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent

    fun createTvShowSubComponent():TvShowSubComponent

    fun createArtistSubComponent():ArtistSubComponent
}