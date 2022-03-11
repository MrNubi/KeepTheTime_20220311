package com.example.keepthetime_20220311

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.keepthetime_20220311.api.APIList
import com.example.keepthetime_20220311.api.ServerAPI
import com.example.keepthetime_20220311.databinding.ActivitySiginInBinding
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SiginInActivity : BaseActivity() {

    lateinit var binding:ActivitySiginInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sigin_in)
        SetupEvents()
        setValues()
    }

    override fun SetupEvents() {

        binding.btnLogin.setOnClickListener {

            val inputEmail =  binding.edtEmail.text.toString()
            val inputPassword = binding.edtPassword.text.toString()

            apiList.postRequestLogin(inputEmail, inputPassword).enqueue(object :Callback<JSONObject>{
                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {

                    Log.d("응답확인", response.toString())
                    // 테스트용 아이디: test@test.com  / 비번: Test!123
                }

                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                    // 서버에 물리적 연결 실패
                }
            })
        }
    }

    override fun setValues() {

    }
}