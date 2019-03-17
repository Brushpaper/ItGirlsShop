package com.example.margarita_rezaeva_shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainAct_TopText.onClick(){
            startActivity<CategoryActivity>()
        }
        MainAct_BottomText.onClick(){
            startActivity<CategoryActivity>()
        }

        Picasso.get()
            .load("https://user-images.githubusercontent.com/48313651/54498159-67bb1c00-4914-11e9-81dd-419fee177e3f.png")
            .into(pictureView)
    }

}
