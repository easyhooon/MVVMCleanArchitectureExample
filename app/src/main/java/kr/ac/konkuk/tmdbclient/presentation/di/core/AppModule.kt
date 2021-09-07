package kr.ac.konkuk.tmdbclient.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.presentation.di.artist.ArtistSubComponent
import kr.ac.konkuk.tmdbclient.presentation.di.movie.MovieSubComponent
import kr.ac.konkuk.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

//provides the application context dependency
@Module(subcomponents = [
    MovieSubComponent::class,
    TvShowSubComponent::class,
    ArtistSubComponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}