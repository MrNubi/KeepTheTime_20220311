package com.example.keepthetime_20220311

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.keepthetime_20220311.adapters.MyPlacesRecyclerAdapter
import com.example.keepthetime_20220311.databinding.ActivityManagePlaceBinding
import com.example.keepthetime_20220311.datas.BasicResponse
import com.example.keepthetime_20220311.datas.PlaceData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ManagePlaceActivity : BaseActivity() {

    lateinit var binding:ActivityManagePlaceBinding

    val mPlaceList=ArrayList<PlaceData>()

    lateinit var mPlaceAdapter: MyPlacesRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_manage_place)

        SetupEvents()
        setValues()
    }

    override fun SetupEvents() {

        btnAdd.setOnClickListener {
            // 장소 추가화면 이동
            val myIntent = Intent(mContext, EditMyPlaceActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        
        txtTitle.text = "내 출발 장소 관리"
        btnAdd.visibility = View.VISIBLE  // 숨겨져있던 추가 버튼을 보이게

        mPlaceAdapter = MyPlacesRecyclerAdapter(mContext,mPlaceList)
        binding.myPlaceRecyclerView.adapter = mPlaceAdapter
        binding.myPlaceRecyclerView.layoutManager = LinearLayoutManager(mContext)
    }

    override fun onResume() {
        super.onResume()
        getMyPlacesFromServer()
    }

    fun getMyPlacesFromServer(){

        apiList.getRequestPlacestList().enqueue(object :Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if(response.isSuccessful){
                    val br = response.body()!!

                    mPlaceList.clear()

                    mPlaceList.addAll(br.data.places)

                    mPlaceAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })
    }
}