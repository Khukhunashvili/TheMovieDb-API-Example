package com.finkacho.themoviedbapiexample.ui

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.finkacho.themoviedbapiexample.R
import kotlinx.android.synthetic.main.activity_details.*
import com.bumptech.glide.request.transition.Transition


class DetailsActivity : AppCompatActivity() {

    lateinit var title: String
    lateinit var releaseDate: String
    lateinit var overview: String
    lateinit var posterPath: String
    var voteAverage: Int = 0

    val imagePath: String = "https://image.tmdb.org/t/p/w500"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        title = intent.getStringExtra("TITLE")
        releaseDate = intent.getStringExtra("RELEASE_DATE")
        voteAverage = intent.getIntExtra("VOTE_AVERAGE", 0)
        overview = intent.getStringExtra("OVERVIEW")
        posterPath = intent.getStringExtra("POSTER_PATH")


        setTitle(title)
        Glide.with(this).load(imagePath+posterPath).into(object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                detailsView.background = resource
                detailsImage.setImageDrawable(resource)
            }
        })
        detailsDate.text = releaseDate
        detailsScore.text = voteAverage.toString()
        detailsOverview.text = overview

    }
}
