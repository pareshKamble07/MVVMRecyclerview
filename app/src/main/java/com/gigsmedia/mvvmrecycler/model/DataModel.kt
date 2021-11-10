package com.gigsmedia.mvvmrecycler.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class DataModel {
    @SerializedName("result")
    @Expose
    private var result: Result? = null

    fun getResult(): Result? {
        return result
    }

    fun setResult(result: Result?) {
        this.result = result
    }

    override fun toString(): String {
        return "DataModel(result=$result)"
    }


}