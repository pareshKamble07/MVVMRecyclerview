package com.gigsmedia.mvvmrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gigsmedia.mvvmrecycler.adapter.UserAdapter
import com.gigsmedia.mvvmrecycler.databinding.ActivityMainBinding
import com.gigsmedia.mvvmrecycler.model.DataModel
import com.gigsmedia.mvvmrecycler.model.User
import com.gigsmedia.mvvmrecycler.viewmodel.UserListViewModel

class MainActivity : AppCompatActivity() {

    private var userModelList: List<DataModel> = ArrayList()
    private var adapter: UserAdapter? = null
    private var viewModel: UserListViewModel? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layoutManager = LinearLayoutManager(this)

        binding.rvUserData.setLayoutManager(layoutManager)

        viewModel = ViewModelProviders.of(this)[UserListViewModel::class.java]
        viewModel!!.allDeveloper.observe(this,
            Observer<List<Any>> { mDeveloperModel ->
                ///if any thing chnage the update the UI
                userModelList = mDeveloperModel as List<DataModel>
                adapter = UserAdapter(this, userModelList)
                binding.rvUserData.adapter = adapter
            })



    }
}