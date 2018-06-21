package com.finkacho.themoviedbapiexample.model

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("id") val id: Int,
        @SerializedName("video") val videoStatus: Boolean,
        @SerializedName("voteAverage") val voteAverage: Int,
        @SerializedName("title") val title: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("adult") val adultStatus: Boolean,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String
)