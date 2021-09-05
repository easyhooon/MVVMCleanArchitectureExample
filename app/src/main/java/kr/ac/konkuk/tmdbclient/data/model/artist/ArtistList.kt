package kr.ac.konkuk.tmdbclient.data.model.artist


import com.google.gson.annotations.SerializedName
import kr.ac.konkuk.tmdbclient.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>
)