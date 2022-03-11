package com.example.keepthetime_20220311

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.keepthetime_20220311.databinding.ActivitySiginInBinding

class SignUpActivity : BaseActivity() {

    lateinit var binding : ActivitySiginInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        SetupEvents()
        setValues()
    }

    override fun SetupEvents() {

    }

    override fun setValues() {

    }
}