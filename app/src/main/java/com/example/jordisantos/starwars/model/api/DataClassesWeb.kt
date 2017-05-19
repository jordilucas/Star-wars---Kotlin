package com.example.jordisantos.starwars.model.api

import com.google.gson.annotations.SerializedName

/**
 * Created by jordisantos on 19/05/17.
 */

data class FilmResult(val results : List<Film>)
data class Film(val title : String, @SerializedName("episode_id")val episodeId : Int,
                @SerializedName("characters")val personUrls : List<String>)
data class Person(val name : String, val gender : String)