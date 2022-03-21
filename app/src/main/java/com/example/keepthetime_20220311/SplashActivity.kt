package com.example.keepthetime_20220311

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.keepthetime_20220311.datas.BasicResponse
import com.example.keepthetime_20220311.utils.ContextUtil
import com.google.firebase.messaging.FirebaseMessaging
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


        // 실제 저장된 토근으로, 내정보 조회 시도 먼저 진행
        // 2.5초 후에, 내정보가 불러와졌는지? 결과에 따라 다른 화면으로 이동
        var isMyInfoLoaded = false
        apiList.getRequestMyInfo().enqueue(object :Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                // code : 200 => 성공 응답이 왔다? 내 정보가 일단 잘 불러졌다
                if(response.isSuccessful){
                    isMyInfoLoaded = true
                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }
        })

        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed({

            val myIntent : Intent

            if(isMyInfoLoaded){
                 myIntent = Intent(mContext, MainActivity::class.java)
            }
            else{
                 myIntent = Intent(mContext, SiginInActivity::class.java)
            }

            startActivity(myIntent)
            finish()

        }, 2500)

        getFCMDeviceToken()

    }

    fun getFCMDeviceToken(){

        FirebaseMessaging.getInstance().token.addOnCompleteListener {

            Log.d("토큰값",it.result!!)
        }
    }
}