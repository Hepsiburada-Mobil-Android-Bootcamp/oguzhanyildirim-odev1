package com.android.figmahomework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.figmahomework.R

class MovieListAdapter(private val movieList: MutableList<String>) :
    RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {
    class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(s: String) {
            itemView.findViewById<TextView>(R.id.tvMovieListName).text = s
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list, parent, false)
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun refresMovieList(newMoviewList: MutableList<String>) {
        movieList.clear()
        movieList.addAll(newMoviewList)
        notifyDataSetChanged()
    }

}