package com.gigsmedia.mvvmrecycler.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Category {

    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("name")
    @Expose
    private val name: String? = null
}