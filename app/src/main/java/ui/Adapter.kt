package ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.followthenews.R
import data.ArticleModel
import kotlinx.android.synthetic.main.item_view.view.*

class Adapter(mainActivity: MainActivity) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var data : ArrayList<ArticleModel>?=null

    fun setData(list: ArrayList<ArticleModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: ArticleModel?) {
            itemView.item_title.text = item?.status
            itemView.item_body.text = item?.response
        }

    }
}