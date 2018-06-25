package com.finkacho.themoviedbapiexample.service

import com.finkacho.themoviedbapiexample.model.MoviePage
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieClient {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") api_key: String, @Query("page") page: Int):Call<MoviePage>


    companion object Factory{
        var BASE_URL: String = "https://api.themoviedb.org/3/"

        fun create(): MovieClient{
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(MovieClient::class.java)
        }
    }
}