package com.pr7.ktretrofit

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        fun getApi():Api{

            val retrofit=Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val api=retrofit.create(Api::class.java)
            return api


        }


    }
}