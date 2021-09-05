package kr.ac.konkuk.tmdbclient.data.model.movie


import com.google.gson.annotations.SerializedName
import kr.ac.konkuk.tmdbclient.data.model.movie.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>,
)