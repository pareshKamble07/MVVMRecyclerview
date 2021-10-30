package com.gigsmedia.mvvmrecyclerview.network

import com.gigsmedia.mvvmrecycler.model.DataModel
import com.gigsmedia.mvvmrecycler.model.User
import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("users")
    fun getUserList(): Call<JsonArray >
}