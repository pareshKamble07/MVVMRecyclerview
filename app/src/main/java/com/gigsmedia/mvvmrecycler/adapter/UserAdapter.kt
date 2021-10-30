package com.gigsmedia.mvvmrecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gigsmedia.mvvmrecycler.databinding.RvUserLayoutBinding
import com.gigsmedia.mvvmrecycler.model.DataModel
import com.gigsmedia.mvvmrecycler.model.User


class UserAdapter (val context: Context, private val mList: List<DataModel>?) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: RvUserLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvUserLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){
            with(mList?.get(position)){
                binding.tvName.text = this!!.name
              //  binding.tvEmail.text = this!!.email
                Glide.with(context).load(this!!.image).into(binding.imgUser)
            }

        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList!!.size
    }


}