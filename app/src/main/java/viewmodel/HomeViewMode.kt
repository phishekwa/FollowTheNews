package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import data.ArticleModel
import data.Repo

class HomeViewMode {
    private var homeRepository:Repo?=null
    var postModelListLiveData : LiveData<List<ArticleModel>>?=null

    init {
        homeRepository = Repo()
        postModelListLiveData = MutableLiveData()
    }

    fun fetchAllPosts(){
        postModelListLiveData = homeRepository?.myArticles()
    }
}