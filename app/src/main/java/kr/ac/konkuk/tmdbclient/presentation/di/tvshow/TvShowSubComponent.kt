package kr.ac.konkuk.tmdbclient.presentation.di.tvshow

import dagger.Subcomponent
import kr.ac.konkuk.tmdbclient.presentation.artist.ArtistActivity
import kr.ac.konkuk.tmdbclient.presentation.di.artist.ArtistModule
import kr.ac.konkuk.tmdbclient.presentation.di.artist.ArtistScope
import kr.ac.konkuk.tmdbclient.presentation.tvshow.TvShowActivity


//we will use this subcomponent to inject dependencies to artist activity
//therefore we need to define an inject function here keeping an instance of artist activity as a parameter
@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():TvShowSubComponent
    }
}
//we must define a subcomponent factory inside this
//ArtistComponent so that AppComponent knows how to create
//instances of this ArtistComponent sub component