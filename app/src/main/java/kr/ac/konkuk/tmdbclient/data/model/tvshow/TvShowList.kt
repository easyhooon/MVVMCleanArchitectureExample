package kr.ac.konkuk.tmdbclient.data.model.tvshow


import com.google.gson.annotations.SerializedName
import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)