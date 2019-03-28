package com.example.root.mymvp.activities

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.root.mymvp.R
import com.example.root.mymvp.adapters.NewsAdapter
import com.example.root.mymvp.databinding.ActivityMainBinding
import com.example.root.mymvp.model.News
import com.example.root.mymvp.presentrer.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityPresenter.ViewInterface {

    lateinit var context: Context
    var TAG = MainActivity::class.java.simpleName
    var mainPresenter: MainActivityPresenter? = null
    lateinit var binding: ActivityMainBinding
    lateinit var rvNews: RecyclerView
    lateinit var newsAdapter: NewsAdapter
    lateinit var newsList: ArrayList<News.ArticlesBean>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        context = this@MainActivity

        init()
    }


    fun init() {
        //Class
        newsList = arrayListOf()
        newsAdapter = NewsAdapter(context, newsList)


        //ViewInterface
        rvNews = binding.rvNews
        rvNews.layoutManager = LinearLayoutManager(context)
        rvNews.adapter = newsAdapter


        mainPresenter = MainActivityPresenter(context, this)
        mainPresenter!!.loadArticle()

    }

    override fun receiveNewsResponse(news: News) {
        Log.e(TAG, "News Size---> " + (news.articles?.size))
        news.articles?.let { newsList.addAll(it) }
        newsAdapter.notifyDataSetChanged()

    }
}
