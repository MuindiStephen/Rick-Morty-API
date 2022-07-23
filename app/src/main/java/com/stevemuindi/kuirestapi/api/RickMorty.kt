package com.stevemuindi.kuirestapi.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RickMorty {

    private val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create()).build()  //Converts GSON to Json and viceversa

    val api by lazy { retrofit.create(ApiService::class.java) }
   // val api = retrofit.create(ApiService::class.java)

}