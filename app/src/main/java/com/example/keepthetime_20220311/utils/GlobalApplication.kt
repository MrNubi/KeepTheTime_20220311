package com.example.keepthetime_20220311.utils

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "4618b9a059951cee7511a7ed5876ae90")

    }
}