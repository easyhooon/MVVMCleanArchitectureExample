package kr.ac.konkuk.tmdbclient.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.konkuk.tmdbclient.R
import kr.ac.konkuk.tmdbclient.data.model.movie.Movie
import kr.ac.konkuk.tmdbclient.databinding.ActivityMovieBinding
import kr.ac.konkuk.tmdbclient.presentation.di.Injector
import kr.ac.konkuk.tmdbclient.presentation.di.movie.MovieAdapter
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {


    @Inject
    lateinit var factoy : MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel=ViewModelProvider(this, factoy)
            .get(MovieViewModel::class.java)

        initRecyclerView()


    }

    private fun initRecyclerView(){
        binding.movieProgressBar.visibility = View.VISIBLE
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}