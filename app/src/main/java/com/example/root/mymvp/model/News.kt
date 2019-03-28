package com.example.root.mymvp.model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide


class News {


    var articles: ArrayList<ArticlesBean>? = null

    var totalResults: Int = 0

    var status: String? = null



    class ArticlesBean {

        companion object {
            @BindingAdapter("bind:imageUrl")
            @JvmStatic
            fun loadImage(view: ImageView, imageUrl: String) {
                Glide.with(view.context).load(imageUrl).into(view);
            }

        }


        var id:Int?=null

        var content: String? = null

        var publishedAt: String? = null


        var urlToImage: String? = null

        var url: String? = null


        var description: String? = null


        var title: String? = null

        var author: String? = null

        var source: SourceBean? = null


    }

    class SourceBean {

        var name: String? = null

       // var id: String? = null
    }


}
