package kr.ac.konkuk.tmdbclient.presentation.di.artist

import dagger.Subcomponent
import kr.ac.konkuk.tmdbclient.presentation.artist.ArtistActivity


//we will use this subcomponent to inject dependencies to artist activity
//therefore we need to define an inject function here keeping an instance of artist activity as a parameter
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():ArtistSubComponent
    }
}
//we must define a subcomponent factory inside this
//ArtistComponent so that AppComponent knows how to create
//instances of this ArtistComponent sub component