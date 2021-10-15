package com.android.figmahomework.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.figmahomework.R
import com.android.figmahomework.adapter.MovieListAdapter
import com.android.figmahomework.databinding.ActivityMovieListBinding
import com.android.figmahomework.viewmodel.MovieListViewModel

class MovieListActivity : AppCompatActivity(), View.OnClickListener {

    private var binding : ActivityMovieListBinding? = null
    private var viewModel : MovieListViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)


        val adapter = MovieListAdapter(listOf<String>().toMutableList())
        binding?.apply {
            rvMovies.layoutManager = LinearLayoutManager(this@MovieListActivity)
            binding?.rvMovies?.adapter = adapter

        }


        viewModel?.data?.observe(this, {
            adapter.refresMovieList(it)
        })

        binding?.btnAddMovie?.setOnClickListener(this)
        
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnAddMovie -> {
                val givenInput = binding?.etInput?.text.toString()
                if (givenInput.isNotEmpty()){
                    viewModel?.addMovie(givenInput)
                }
            }
        }
    }
}