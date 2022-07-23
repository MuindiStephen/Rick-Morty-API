package com.stevemuindi.kuirestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.stevemuindi.kuirestapi.adapter.CharactersAdapter
import com.stevemuindi.kuirestapi.api.RickMorty
import com.stevemuindi.kuirestapi.model.CharactersResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Url
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {


    private val adapter by lazy { CharactersAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val progressBar:ProgressBar = findViewById(R.id.progressBar)
        val myRecycleView:RecyclerView = findViewById(R.id.recyclerView2)

        //select callback with retrofit 2
        RickMorty.api.getCharacters().enqueue(object: retrofit2.Callback<CharactersResponse>{
            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                progressBar.isVisible = false
                if (response.isSuccessful){
                    adapter.submitList(response.body()?.results)
                    myRecycleView.adapter = adapter
                }
             }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
               Toast.makeText(applicationContext,t.message,Toast.LENGTH_SHORT).show()
                progressBar.isVisible = false
            }

        })

    }
}