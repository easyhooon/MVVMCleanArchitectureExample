package kr.ac.konkuk.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.ac.konkuk.tmdbclient.R
import kr.ac.konkuk.tmdbclient.data.model.artist.Artist
import kr.ac.konkuk.tmdbclient.data.model.movie.Movie
import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShow
import kr.ac.konkuk.tmdbclient.databinding.ListItemBinding



//MyViewHolder 클래스를 먼저 구현하고 상속받아야 에러때매 꼬이지 않는다
class TvShowAdapter():RecyclerView.Adapter<MyViewHolder>(){
    //Here at the top of the class, Let's define an arrayList for movies
    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows:List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // 1)
        //to create view holder, we will get the layout inflater.
        //create a dataBinding object for the layout using it
        //and then, construct a view holder passing that data binding object.
        val layoutInflater = LayoutInflater.from(parent.context)
        //we need to provide the object type
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // 3)
        //using this position value
        //we can get the relevant movie object and pass it to the holder
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        // 2)
        return tvShowList.size
    }

}

//Since we are using dataBinding, we need to add the dataBinding object as a constructor parameter

//this class should extend the RecyclerView.ViewHolder class
//we need to pass binding.root as an argument to the ViewHolder

//we use this class to bind values to the views
class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview

        val posterURL = "https://image.tmdb.org/t/p/w500"+ tvShow.posterPath

        //we need to provide the context of the view
        Glide.with(binding.imageView.context)
        //then load the image
            .load(posterURL)
            .into(binding.imageView)

    }

}