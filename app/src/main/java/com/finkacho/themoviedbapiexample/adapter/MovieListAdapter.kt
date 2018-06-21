package com.finkacho.themoviedbapiexample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.finkacho.themoviedbapiexample.R
import com.finkacho.themoviedbapiexample.model.Movie

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>(){

    var mMovies: MutableList<Movie> = mutableListOf()

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val movieImage: ImageView = view.findViewById(R.id.movieImage)
        val movieTitle: TextView = view.findViewById(R.id.movieTitle)
        val cardLayout: RelativeLayout = view.findViewById(R.id.cardLayout)

        val imagePath: String = "https://image.tmdb.org/t/p/w500"

        fun bind(movie: Movie){
            movieTitle.text = movie.title
            Glide.with(view).load(imagePath+movie.posterPath).into(movieImage)
            cardLayout.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_cell, parent, false) as View
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mMovies[position])
    }

    override fun getItemCount(): Int {
        return mMovies.size
    }

    fun addData(movies: List<Movie>?){
        mMovies.addAll(movies!!)
        notifyDataSetChanged()
    }

}