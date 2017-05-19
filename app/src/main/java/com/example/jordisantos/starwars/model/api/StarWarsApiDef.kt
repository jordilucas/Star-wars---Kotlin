package com.example.jordisantos.starwars.model.api

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by jordisantos on 19/05/17.
 */

interface StarWarsApiDef {
    @GET("films")
    fun listMovies() : Observable<FilmResult>

    @GET("people/{personId}")
    fun loadPerson(@Path("personId") personId : String) : Observable<Person>

}
