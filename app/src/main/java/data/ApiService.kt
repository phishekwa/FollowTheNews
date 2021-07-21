package data

import data.ArticleModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET()
    fun getArticles() :Call<List<ArticleModel>>
}