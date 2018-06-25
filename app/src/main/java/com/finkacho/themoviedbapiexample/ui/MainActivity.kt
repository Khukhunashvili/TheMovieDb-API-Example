package com.finkacho.themoviedbapiexample.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.finkacho.themoviedbapiexample.R
import com.finkacho.themoviedbapiexample.adapter.MovieListAdapter
import com.finkacho.themoviedbapiexample.model.MoviePage
import com.finkacho.themoviedbapiexample.service.MovieClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: MovieListAdapter
    private lateinit var viewManager: GridLayoutManager

    private var page: Int = 1

    private val API_KEY: String = "158b2086440f843d5a934416a3832919"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = GridLayoutManager(this,2)
        recyclerAdapter = MovieListAdapter(this)

        recyclerView = findViewById<RecyclerView>(R.id.mainMovieList).apply{
            layoutManager = viewManager
            adapter = recyclerAdapter
        }

        getData(1)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if(!recyclerView?.canScrollVertically(1)!!){
                    getData(page)
                }
            }
        })

    }


    fun getData(pageInfo: Int){
        val client: MovieClient = MovieClient.create()
        val call: Call<MoviePage> = client.getMovies(API_KEY, pageInfo)

        call.enqueue(object : Callback<MoviePage> {
            override fun onFailure(call: Call<MoviePage>?, t: Throwable?) {
                Log.d("MAINACTIVITY.CLASS", t.toString())
            }

            override fun onResponse(call: Call<MoviePage>?, response: Response<MoviePage>?) {
                val movies = response?.body()?.movies
                recyclerAdapter.addData(movies)
            }

        })
        page++
    }
}
