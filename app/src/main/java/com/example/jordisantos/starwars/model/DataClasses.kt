package com.example.jordisantos.starwars.model

/**
 * Created by jordisantos on 19/05/17.
 */

data class Movie(val title : String, val episodeId : Int, val characters : MutableList<Character>)

data class Character(val name : String, val gender : String){
    override fun toString(): String {
        return "${name} - ${gender}"
    }
}
