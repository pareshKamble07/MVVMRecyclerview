package com.gigsmedia.mvvmrecycler.network

import com.gigsmedia.mvvmrecyclerview.network.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val BASE_URL = "https://stage-services.truemeds.in/"
    private var retrofit: Retrofit? = null

    val service: APIService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create<APIService>(APIService::class.java!!)
        }
}