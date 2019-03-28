package com.example.root.mymvp.presentrer

import android.content.Context
import android.util.Log
import com.example.root.mymvp.model.News
import com.example.root.mymvp.retrofit.APIInterface
import com.example.root.mymvvp.retrofit.APIClient
import com.example.root.mymvvp.utility.ApisUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPresenter(var context: Context, var view : ViewInterface) {


   public fun loadArticle() {


        var retrofitClient: APIClient = APIClient()
        var apiInterface: APIInterface = retrofitClient.getClient().create(APIInterface::class.java)
        var call: Call<News> = apiInterface.getNews(ApisUrl.SOURCE, ApisUrl.API_KEY)

        call.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {

                //finally we are setting the list to our MutableLiveData
                var news: News = response.body()!!
                view.receiveNewsResponse(news)


            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("TAG", "OnFailure---> " + t.toString())


            }
        })

    }



    public interface ViewInterface {
        fun receiveNewsResponse(news:News)
    }

}