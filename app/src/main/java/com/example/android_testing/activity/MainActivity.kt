package com.example.android_testing.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android_testing.R
import com.example.android_testing.model.Post
import com.example.android_testing.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiPostList()
    }

    private fun apiPostList() {
        RetrofitHttp.postService.listPost().enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                Log.d("MainActivity", response.body().toString())
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }
        })
    }
}