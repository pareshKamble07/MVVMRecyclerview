package com.gigsmedia.mvvmrecycler.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gigsmedia.mvvmrecycler.model.DataModel
import com.gigsmedia.mvvmrecycler.repository.UserRepo
import okhttp3.ResponseBody

class UserListViewModel : ViewModel() {

    private val userRepo = UserRepo()

    val allDeveloper: LiveData<DataModel>
        get() = userRepo.getMutableLiveData()

}
