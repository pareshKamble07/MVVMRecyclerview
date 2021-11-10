package com.gigsmedia.mvvmrecycler.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Article {

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("categoryName")
    @Expose
    private var categoryName: String? = null

    @SerializedName("type")
    @Expose
    private var type: Int? = null

    @SerializedName("author")
    @Expose
    private var author: String? = null

    @SerializedName("categoryId")
    @Expose
    private var categoryId: Int? = null

    @SerializedName("url")
    @Expose
    private var url: Any? = null

    @SerializedName("createdOn")
    @Expose
    private var createdOn: String? = null

    @SerializedName("image")
    @Expose
    private var image: Any? = null

    @SerializedName("articleTime")
    @Expose
    private var articleTime: Int? = null

    @SerializedName("ranking")
    @Expose
    private var ranking: Int? = null

    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getCategoryName(): String? {
        return categoryName
    }

    fun setCategoryName(categoryName: String?) {
        this.categoryName = categoryName
    }

    fun getType(): Int? {
        return type
    }

    fun setType(type: Int?) {
        this.type = type
    }

    fun getAuthor(): String? {
        return author
    }

    fun setAuthor(author: String?) {
        this.author = author
    }

    fun getCategoryId(): Int? {
        return categoryId
    }

    fun setCategoryId(categoryId: Int?) {
        this.categoryId = categoryId
    }

    fun getUrl(): Any? {
        return url
    }

    fun setUrl(url: Any?) {
        this.url = url
    }

    fun getCreatedOn(): String? {
        return createdOn
    }

    fun setCreatedOn(createdOn: String?) {
        this.createdOn = createdOn
    }

    fun getImage(): Any? {
        return image
    }

    fun setImage(image: Any?) {
        this.image = image
    }

    fun getArticleTime(): Int? {
        return articleTime
    }

    fun setArticleTime(articleTime: Int?) {
        this.articleTime = articleTime
    }

    fun getRanking(): Int? {
        return ranking
    }

    fun setRanking(ranking: Int?) {
        this.ranking = ranking
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }
}