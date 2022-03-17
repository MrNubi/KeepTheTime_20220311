package com.example.keepthetime_20220311

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.keepthetime_20220311.api.APIList
import com.example.keepthetime_20220311.api.ServerAPI

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext:Context

    // 모든 화면에서, apiList 변수가 있다면 => apiList.서버기능(  ) 형태로 간단히 코딩 가능
    lateinit var apiList : APIList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext =  this

        val retrfit = ServerAPI.getRetrofit(mContext)
        apiList = retrfit.create(APIList::class.java)

        supportActionBar?.let {
            setCustomActionBar()
        }
    }

    abstract fun SetupEvents()
    abstract fun setValues()

    fun setCustomActionBar(){

        val defaultActionBar = supportActionBar!!

        defaultActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
//        defaultActionBar.setDisplayShowCustomEnabled(true)

        defaultActionBar.setCustomView(R.layout.my_custom_action_bar)

        val toolBar = defaultActionBar.customView.parent as Toolbar
        toolBar.setContentInsetsAbsolute(0,0)
    }
}