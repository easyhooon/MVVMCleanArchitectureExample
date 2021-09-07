package kr.ac.konkuk.tmdbclient.presentation.di.core

import dagger.Component
import kr.ac.konkuk.tmdbclient.presentation.di.artist.ArtistSubComponent
import kr.ac.konkuk.tmdbclient.presentation.di.movie.MovieSubComponent
import kr.ac.konkuk.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

//@Singleton is the only scope annotation that comes with the javax.inject package.
//
//We can use it to annotate ApplicationComponent and the objects we want to reuse across the whole application.
//
//That’s why we annotated
//
//provider methods which provides dependencies we want to reuse across the whole application with
//
//Singleton annotation.

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DataBaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory

    fun tvShowSubComponent():TvShowSubComponent.Factory

    fun artistSubComponent():ArtistSubComponent.Factory
}