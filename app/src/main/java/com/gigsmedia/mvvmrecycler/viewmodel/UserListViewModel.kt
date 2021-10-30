package com.gigsmedia.mvvmrecycler.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigsmedia.mvvmrecycler.model.DataModel
import com.gigsmedia.mvvmrecycler.model.User
import com.gigsmedia.mvvmrecycler.network.RetrofitClient
import com.gigsmedia.mvvmrecycler.repository.UserRepo
import com.gigsmedia.mvvmrecyclerview.network.APIService
import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListViewModel : ViewModel() {

    private val userRepo: UserRepo

    val allDeveloper: LiveData<List<DataModel>>
        get() = userRepo.getMutableLiveData()

    init {
        userRepo = UserRepo()
    }
}
