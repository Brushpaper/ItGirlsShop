package com.example.margarita_rezaeva_shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    }
}
