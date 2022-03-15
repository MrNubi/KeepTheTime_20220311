package com.example.keepthetime_20220311

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.keepthetime_20220311.adapters.MyFriendAdapter
import com.example.keepthetime_20220311.databinding.ActivityManageMyFriendsBinding
import com.example.keepthetime_20220311.datas.BasicResponse
import com.example.keepthetime_20220311.datas.UserData
import com.example.keepthetime_20220311.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ManageMyFriendsActivity : BaseActivity() {

    lateinit var binding: ActivityManageMyFriendsBinding

//    val mFriendList = ArrayList<UserData>()
//    lateinit var mAdapter:MyFriendAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_my_friends)

        SetupEvents()
        setValues()
    }

    override fun SetupEvents() {

        binding.btnAddFriend.setOnClickListener {

            val myIntent =  Intent(mContext, SearchUserActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

//        getMyFriendListFromServer()
//
//        mAdapter = MyFriendAdapter(mContext, R.layout.my_frined_list_item, mFriendList)
//        binding.myFriendsListView.adapter = mAdapter

    }

//    fun getMyFriendListFromServer(){
//        // 테스트용 아아디 test@test.com  /  비번  Test!123
//
//        apiList.getRequestFriendList(
//            "my"    // 수락이 완료된 친구목록만 불러오기
//        ).enqueue(object :Callback<BasicResponse>{
//            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
//
//                if(response.isSuccessful){
//                    val br = response.body()!!
////                    Log.d("친구목록", br.data.friends.toString())
//                    // br.data.friends는 UserData 목록으로 이미내려옴
//                    // 목록의 내용물을 통째로 => mFriendList 변수의 내용물로 담자
//                    mFriendList.addAll(br.data.friends)
//
//                    // 어댑터 새로 고침
//                    mAdapter.notifyDataSetChanged()
//                }
//            }
//
//            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
//
//            }
//        })
//    }
}