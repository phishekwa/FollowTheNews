package ui

val repo = data.Repo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.followthenews.R
import kotlinx.android.synthetic.main.activity_main.*
import viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this)[ViewModel::class.java]

        theAdapter()

        vm.fetchAllPosts()

        vm.postModelListLiveData?.observe(this, Observer {
            if (it!=null){
                rv_home.visibility = View.VISIBLE
              var  adapter.setData(it as ArrayList<ArticleModel>)
            }else{
                showToast("Something went wrong")
            }
            //we can put progress bar here
        })

    }

    //Initiating the adapter
    private fun theAdapter() {
       val  adapter = Adapter(this)
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = adapter
    }
}