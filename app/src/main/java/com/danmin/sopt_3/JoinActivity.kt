package com.danmin.sopt_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.danmin.sopt_3.data.RequestJoin
import com.danmin.sopt_3.data.ResponseJoin
import com.danmin.sopt_3.network.RequestJoinToServer
import kotlinx.android.synthetic.main.activity_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val requestToServer = RequestJoinToServer

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        join_btn.setOnClickListener {
            if (join_check_pw.text.toString() != join_pw.text.toString()) {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            } else {
                // join request
                requestToServer.service.requestJoin(
                    RequestJoin(
                        id = join_email.text.toString(),
                        name = join_name.text.toString(),
                        password = join_pw.text.toString(),
                        email = join_email.text.toString(),
                        phone = join_phone.text.toString()
                    )
                ).enqueue(object : Callback<ResponseJoin> {
                    override fun onFailure(call: Call<ResponseJoin>, t: Throwable) {
                        //fail
                        Log.e("error", t.toString())
                        Toast.makeText(this@JoinActivity, "회원가입 실패", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<ResponseJoin>,
                        response: Response<ResponseJoin>
                    ) {
                        if (response.isSuccessful) {
                            if (response.body()!!.success) {
                                Toast.makeText(this@JoinActivity, "회원가입 성공", Toast.LENGTH_SHORT)
                                    .show()
                                val intent = Intent()
                                intent.putExtra("email", join_email.text.toString())
                                intent.putExtra("password", join_pw.text.toString())
                                setResult(Activity.RESULT_OK, intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@JoinActivity,
                                    "모든 정보를 입력하세요",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }
    }
}
