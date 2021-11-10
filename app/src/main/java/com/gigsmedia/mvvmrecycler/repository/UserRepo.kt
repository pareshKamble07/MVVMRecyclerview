package com.gigsmedia.mvvmrecycler.repository


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gigsmedia.mvvmrecycler.model.DataModel
import com.gigsmedia.mvvmrecycler.model.Result
import com.gigsmedia.mvvmrecycler.network.RetrofitClient
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.ResponseBody

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo {
    private val mutableLiveData = MutableLiveData<DataModel>()

    private var TAG = "Logger"

    ////call to internet and  retun  MutableLiveData
    fun getMutableLiveData(): MutableLiveData<DataModel> {

        ///ini Retrofit Class
        val userDataService = RetrofitClient.service

        ///call the API that define In Interface
        val call = userDataService.getUserList()

        call.enqueue(object : Callback<DataModel> {

            internal var message: String? = null

            override fun onResponse(call: Call<DataModel>, resp: Response<DataModel>) {

                if (resp != null && resp.body() != null) {
                    mutableLiveData.value = resp.body()

                    Log.e(TAG,resp.body().toString())
                }else
                {
                    Log.e(TAG,"response is null")
                }

            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                t.printStackTrace()
                Log.e(TAG,t.message.toString())
            }
        })


        return mutableLiveData
    }

}