package com.example.margarita_rezaeva_shop

import android.annotation.SuppressLint
import android.content.Context
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
import org.jetbrains.anko.connectivityManager
import java.io.File
import java.lang.Exception

interface RequestMaker {
    fun make(
        url: String,
        onResult: (result: String) -> Unit,
        onError: () -> Unit
    )
}

class OkHttpRequestMaker(
    val context: Context
) : RequestMaker {
    override fun make(
        url: String,
        onResult: (result: String) -> Unit,
        onError: () -> Unit
    ): Unit = run {
        GlobalScope.launch(Dispatchers.Main) {
            val file = File(context.cacheDir, urlToValidFileName(url))
            if (isOnline()) {
                val resultDeferred = GlobalScope.async(Dispatchers.IO) {
                    makeRequest(url)
                }
                try {
                    val result = resultDeferred.await()
                    cache(file, result)
                    onResult(result)
                } catch (e: Exception) {
                    showPreviousResult(file, onResult, onError)
                }
            } else {
                showPreviousResult(file, onResult, onError)
            }
        }
    }


    fun showPreviousResult(
        file: File,
        onResult: (result: String) -> Unit,
        onError: () -> Unit
    ) = run {
        try {
            val previousResult = file.readText()
            onResult(previousResult)
        } catch (e: Exception) {
            onError()
        }
    }

    fun cache(file: File, result: String) = run {
        file.parentFile.mkdirs()
        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()
        file.writeText(result)
    }

    @SuppressLint("MissingPermission")
    fun isOnline() = run {
        val netInfo = context.connectivityManager.activeNetworkInfo
        netInfo != null && netInfo.isConnectedOrConnecting
    }

    fun urlToValidFileName(url: String) = url
        .replace("/", "a")
        .replace(":", "b")

    private fun makeRequest(url: String) = run {

        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()

        val response = client.newCall(request).execute()

        response.body()!!.string()
    }

}


