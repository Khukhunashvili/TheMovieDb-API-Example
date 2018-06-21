package com.finkacho.themoviedbapiexample.model

import com.google.gson.annotations.SerializedName

data class MoviePage(
        @SerializedName("page") val page: Int,
        @SerializedName("total_results") val totalResults: Int,
        @SerializedName("total_pages") val totalPages: Int,
        @SerializedName("results") val movies: List<Movie>
)