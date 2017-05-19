package com.example.jordisantos.starwars

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.jordisantos.starwars.model.api.StarWarsApi
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    var listView : ListView? = null
    var movies = mutableListOf<String>()
    var movieAdapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listView = ListView(this)
        setContentView(listView)
        movieAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, movies)
        listView?.adapter = movieAdapter

        val api = StarWarsApi()
        api.loadMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    movie -> movies.add("${movie.title} - ${movie.episodeId}")
                }, {
                    e -> e.printStackTrace()
                },{
                    movieAdapter?.notifyDataSetChanged()
                })

    }
}
