package data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val theUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=mostpopular&api-key=vVrCGoUggOR01IL3Hs0u2cbX91DEXLWC"

class ApiClient {
    companion object{
        private var theRetrofit:Retrofit?=null
        fun getApiCliecnt(): Retrofit {
            val gson = GsonBuilder().setLenient().create()
            val okHttpClient = OkHttpClient.Builder().readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS).build()

            if(theRetrofit == null){
                theRetrofit = Retrofit.Builder().baseUrl(theUrl).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return theRetrofit!!
        }
    }
}