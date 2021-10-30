package com.gigsmedia.mvvmrecycler.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class DataModel {

    @SerializedName("login")
    @Expose
    public var name: String? = null

    @SerializedName("avatar_url")
    @Expose
    public var image: String? = null






}