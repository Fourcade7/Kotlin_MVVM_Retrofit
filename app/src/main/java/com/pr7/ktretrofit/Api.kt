package com.pr7.ktretrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("posts")
    fun getPosts():Call<ArrayList<PostResponse>>

}