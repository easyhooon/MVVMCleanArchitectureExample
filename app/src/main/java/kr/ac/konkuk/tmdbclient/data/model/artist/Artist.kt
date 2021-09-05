package kr.ac.konkuk.tmdbclient.data.model.artist


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//retrofit data class + room Entity

//if we keep this in this way, room database table name will be same as the data class name
//Table name will be artist
//if want different name, @Entity(tableName= )
@Entity(tableName = "popular_artists")
data class Artist(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    //different name way @ColumnInfo(name = "artist_name")
    @SerializedName("name")
    val name: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("profile_path")
    val profilePath: String
)