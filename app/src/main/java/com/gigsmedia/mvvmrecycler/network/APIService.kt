package com.gigsmedia.mvvmrecyclerview.network

import com.gigsmedia.mvvmrecycler.model.DataModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.POST

interface APIService {

    @POST("ArticleService/getArticleListing")
    fun getUserList(): Call<DataModel>
}