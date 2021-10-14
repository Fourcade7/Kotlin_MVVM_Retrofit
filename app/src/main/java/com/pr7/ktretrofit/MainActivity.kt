package com.pr7.ktretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper.HORIZONTAL
import androidx.recyclerview.widget.OrientationHelper.VERTICAL
import com.pr7.ktretrofit.ViewModel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var arrayList = ArrayList<PostResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       getPostsCall()

//999572680 

    }

    fun getPostsCall(){


        val viewmodel= ViewModelProvider(this).get(PostViewModel::class.java)
        viewmodel.makeapicall()
        viewmodel.getarraylistdataobserver().observe(this, Observer<ArrayList<PostResponse>>{
            if (it !=null){

                    recyclerview1.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = MyAdapter(it)
                        val decoration = DividerItemDecoration(applicationContext, VERTICAL)
                        addItemDecoration(decoration)
//                        val decoration2 = DividerItemDecoration(applicationContext, VERTICAL)
//                        addItemDecoration(decoration2)
                    }
            }
            else{

            }
        })


    }

}