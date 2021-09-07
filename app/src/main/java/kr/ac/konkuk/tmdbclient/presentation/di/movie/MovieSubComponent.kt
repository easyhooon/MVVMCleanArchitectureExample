package kr.ac.konkuk.tmdbclient.presentation.di.movie

import dagger.Subcomponent
import kr.ac.konkuk.tmdbclient.presentation.artist.ArtistActivity
import kr.ac.konkuk.tmdbclient.presentation.di.artist.ArtistModule
import kr.ac.konkuk.tmdbclient.presentation.di.artist.ArtistScope
import kr.ac.konkuk.tmdbclient.presentation.movie.MovieActivity


//we will use this subcomponent to inject dependencies to artist activity
//therefore we need to define an inject function here keeping an instance of artist activity as a parameter
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():MovieSubComponent
    }
}
//we must define a subcomponent factory inside this
//ArtistComponent so that AppComponent knows how to create
//instances of this ArtistComponent sub component