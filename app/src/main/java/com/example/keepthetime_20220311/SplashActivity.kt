package com.example.keepthetime_20220311

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        SetupEvents()
        setValues()
    }

    override fun SetupEvents() {

    }

    override fun setValues() {

        // 임시 - 자동로그인 구현전까지는, 2.5초후에 모조건 로그인 화면으로

        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed({
              val myIntent = Intent(mContext, SiginInActivity::class.java)
            startActivity(myIntent)
            finish()

        }, 2500)
    }
}