package data


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Repo {
    fun myArticles(): LiveData<List<ArticleModel>>{
        val data = MutableLiveData<List<ArticleModel>>()
      return data
    }

}