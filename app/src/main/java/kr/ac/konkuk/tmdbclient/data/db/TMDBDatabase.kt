package kr.ac.konkuk.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.ac.konkuk.tmdbclient.data.model.artist.Artist
import kr.ac.konkuk.tmdbclient.data.model.movie.Movie
import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    //these are the room database related components
    abstract fun movieDao(): MovieDao

    abstract fun tvShowDao(): TvShowDao

    abstract fun artistDao(): ArtistDao
}