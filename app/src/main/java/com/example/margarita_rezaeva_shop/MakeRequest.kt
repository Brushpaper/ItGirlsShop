package com.example.margarita_rezaeva_shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import okhttp3.OkHttpClient
import okhttp3.Request

interface RequestMaker {
    fun make(url: String, onResult: (result: String) -> Unit)
}

class OkHttpRequestMaker : RequestMaker {
    override fun make(url: String, onResult: (result: String) -> Unit):Unit = run {
        GlobalScope.launch(Dispatchers.Main) {
            val resultDeferred = GlobalScope.async(Dispatchers.IO) {
                makeRequest(url)
            }
            val result = resultDeferred.await()
            onResult(result)
        }
    }

    private fun makeRequest(url: String) = run {

        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()

        val response = client.newCall(request).execute()

        response.body()!!.string()
    }

}


