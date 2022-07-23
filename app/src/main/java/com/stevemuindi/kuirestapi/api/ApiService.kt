package com.stevemuindi.kuirestapi.api

import com.stevemuindi.kuirestapi.model.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    // One with retrofit 2
    // Making call from the server and make a response
    @GET("character")
 fun getCharacters():Call<CharactersResponse>   //GET request


}