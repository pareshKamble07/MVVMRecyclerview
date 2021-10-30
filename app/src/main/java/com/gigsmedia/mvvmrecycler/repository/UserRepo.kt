package com.gigsmedia.mvvmrecycler.repository


import androidx.lifecycle.MutableLiveData
import com.gigsmedia.mvvmrecycler.model.DataModel
import com.gigsmedia.mvvmrecycler.network.RetrofitClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo {
    private val mmDeveloperModelmist = ArrayList<DataModel>()
    private val mutableLiveData = MutableLiveData<List<DataModel>>()

    ////call to internet and  retun  MutableLiveData
    fun getMutableLiveData(): MutableLiveData<List<DataModel>> {

        ///ini Retrofit Class
        val userDataService = RetrofitClient.service

        ///call the API that define In Interface
        val call = userDataService.getUserList()



        call.enqueue(object : Callback<JsonArray> {

            internal var message: String? = null

            override fun onResponse(call: Call<JsonArray>, resp: Response<JsonArray>) {

                /// parse the data if  Response successfully and store data in MutableLiveData  and retrun to DeveloperViewModel class
                val gson = GsonBuilder().create()

                if (resp != null && resp.body() != null) {

                    val json = JsonParser().parse(resp.body()!!.toString()).asJsonArray
                    //Log.e("data",json.toString())
                    if (json != null) {

                        for (i in 0..json.size() - 1) {
                            try {

                                val jsonobj =
                                    JsonParser().parse(json.get(i).toString()).asJsonObject

                                val responseModel =
                                    gson.fromJson(jsonobj, DataModel::class.java)

                                mmDeveloperModelmist.add(responseModel)

                            } catch (ex: Exception) {

                            }


                        }
                        mutableLiveData.value = mmDeveloperModelmist

                    }
                }


            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                t.printStackTrace()

            }
        })


        return mutableLiveData
    }

}