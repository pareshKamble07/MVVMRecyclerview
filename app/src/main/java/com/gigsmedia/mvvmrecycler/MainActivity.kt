package com.gigsmedia.mvvmrecycler

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gigsmedia.mvvmrecycler.adapter.UserAdapter
import com.gigsmedia.mvvmrecycler.databinding.ActivityMainBinding
import com.gigsmedia.mvvmrecycler.model.Article
import com.gigsmedia.mvvmrecycler.model.DataModel
import com.gigsmedia.mvvmrecycler.viewmodel.UserListViewModel
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    var userModelList = ArrayList<Article>()

    // private var userModelList: List<Article> = ArrayList()
    private var adapter: UserAdapter? = null
    private var viewModel: UserListViewModel? = null

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)

        binding.rvUserData.layoutManager = layoutManager

        viewModel = ViewModelProviders.of(this)[UserListViewModel::class.java]

        startTimer()


        binding.btnReset.setOnClickListener()
        {
            resetTimer()
        }


    }

    fun callAPI() {

        viewModel!!.allDeveloper.observe(this,
            { mDeveloperModel ->

                userModelList.clear()
                binding.rvUserData.visibility = View.VISIBLE

                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()

                val response = gson?.toJson(mDeveloperModel, DataModel::class.java)


                val jsonObject = JSONObject(response)
                val path = jsonObject.getJSONObject("result")

                val jsonArticle = path.getJSONArray("article")
                val length: Int = jsonArticle.length()

                for (i in 0 until length) {
                    val jsonObj: JSONObject = jsonArticle.getJSONObject(i)

                    val data = Article()

                    data.setName(jsonObj.optString("name", ""))
                    data.setCategoryName(jsonObj.optString("categoryName", ""))
                    data.setAuthor(jsonObj.optString("author", ""))
                    data.setImage(jsonObj.optString("image", ""))


                    userModelList.add(data)
                }

                adapter = UserAdapter(this, userModelList)
                binding.rvUserData.adapter = adapter
            })
    }

    private fun startTimer() {

        object : CountDownTimer(60000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                // Used for formatting digit to be in 2 digits only
                val f: NumberFormat = DecimalFormat("00")
                val min = millisUntilFinished / 60000 % 60
                val sec = millisUntilFinished / 1000 % 60
                binding.txtCountDown.text = f.format(min) + ":" + f.format(sec)

            }

            override fun onFinish() {
                binding.txtCountDown.text = ("00:00")
                binding.txtCountDown.visibility = View.GONE
                binding.btnReset.visibility = View.VISIBLE
                callAPI()
            }
        }.start()

    }

    private fun resetTimer() {
        binding.txtCountDown.visibility = View.VISIBLE
        binding.rvUserData.visibility = View.GONE
        binding.btnReset.visibility = View.GONE

        startTimer()

    }


}