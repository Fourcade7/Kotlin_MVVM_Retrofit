package com.pr7.ktretrofit.ViewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.pr7.ktretrofit.MyAdapter
import com.pr7.ktretrofit.PostResponse
import com.pr7.ktretrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel:ViewModel() {
        lateinit var arraylist: MutableLiveData<ArrayList<PostResponse>>

        init {
            arraylist= MutableLiveData()
        }

    fun getarraylistdataobserver():MutableLiveData<ArrayList<PostResponse>>{

        return arraylist
    }

    fun makeapicall(){
        val call = RetrofitClient.getApi().getPosts()
        call.enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ArrayList<PostResponse>>, response: Response<ArrayList<PostResponse>>) {

                if (response.isSuccessful) {
                    arraylist.postValue(response.body())
                }else{
                    arraylist.postValue(null)
                }
            }

        })
    }


}