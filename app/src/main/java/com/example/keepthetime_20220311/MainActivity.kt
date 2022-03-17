package com.example.keepthetime_20220311

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.keepthetime_20220311.adapters.MainViewPager2Adapter
import com.example.keepthetime_20220311.adapters.MainViewPagerAdapter
import com.example.keepthetime_20220311.databinding.ActivityMainBinding
import com.example.keepthetime_20220311.datas.BasicResponse
import com.example.keepthetime_20220311.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var mAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        SetupEvents()
        setValues()
    }

    override fun SetupEvents() {

        btnAdd.setOnClickListener {

            val myIntent = Intent(mContext, EditAppointmentActivity::class.java)
            startActivity(myIntent)
        }

        // 바텀 네비게이션 메뉴 선택 -> 뷰페이저의 페이지 이동
        binding.mainBottomNav.setOnItemSelectedListener {

            // 어떤 메뉴가 선택되었는지? it변수가 알려줌
            when(it.itemId){
                R.id.myAppointment ->{
                    binding.mainViewPager2.currentItem = 0
                    btnAdd.visibility = View.VISIBLE
            }
                R.id.myProfile ->{
                    binding.mainViewPager2.currentItem = 1
                    btnAdd.visibility = View.GONE
                }
            }

            return@setOnItemSelectedListener true
        }
        // 뷰페이지의 페이지 이동 -> 바텀 네비게이션의 메뉴 선택
        binding.mainViewPager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            // 추상메소드 x .  이벤트처리 함수를 직접 오버라이딩해야함
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                binding.mainBottomNav.selectedItemId = when(position){
                    0-> R.id.myAppointment
                    else-> R.id.myProfile
                }
            }
        })
    }

    override fun setValues() {

        binding.mainViewPager2.adapter = MainViewPager2Adapter(this)  // 변수: Activity => 객체: Context대입 불가

    }
}