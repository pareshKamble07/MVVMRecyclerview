package com.gigsmedia.mvvmrecycler.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Result {

    @SerializedName("category")
    @Expose
    private var category: List<Category>? = null

    @SerializedName("article")
    @Expose
    private var article: List<Article>? = null

    fun getCategory(): List<Category>? {
        return category
    }

    fun setCategory(category: List<Category>?) {
        this.category = category
    }

    fun getArticle(): List<Article>? {
        return article
    }

    fun setArticle(article: List<Article>?) {
        this.article = article
    }

    override fun toString(): String {
        return "Result(category=$category, article=$article)"
    }


}