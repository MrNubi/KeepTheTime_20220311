package com.example.keepthetime_20220311

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.keepthetime_20220311.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {

    lateinit var binding : ActivitySignUpBinding

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