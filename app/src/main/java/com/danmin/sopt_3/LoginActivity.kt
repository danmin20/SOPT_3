package com.danmin.sopt_3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.danmin.sopt_3.data.RequestLogin
import com.danmin.sopt_3.data.ResponseLogin
import com.danmin.sopt_3.network.RequestLoginToServer
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    val requestToServer = RequestLoginToServer

    private lateinit var isLoggedIn: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        isLoggedIn = MySharedPreferences(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            if (login_id.text.isNullOrBlank() || login_pw.text.isNullOrBlank()) {
                Toast.makeText(this, "이메일과 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show()
            } else {
                // login request
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = login_id.text.toString(),
                        password = login_pw.text.toString()
                    )
                ).enqueue(object : Callback<ResponseLogin> {
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        // fail
                        Log.e("error",t.toString())
                        Toast.makeText(this@LoginActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        if (response.isSuccessful) {
                            if (response.body()!!.success) {
                                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT)
                                    .show()
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)

                                isLoggedIn.isLoggedIn = "isLoggedIn"
                                finish()
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "아이디/비밀번호를 확인하세요",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }
        gotoJoin.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                100 -> {
                    val savedId = data?.getStringExtra("email").toString()
                    login_id.setText(savedId)
                    val savedPw = data?.getStringExtra("password").toString()
                    login_pw.setText(savedPw)
                }
            }
        }
    }

    // 로그인 유지
    override fun onStart() {
        super.onStart()
        if (isLoggedIn.isLoggedIn == "isLoggedIn") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}

class MySharedPreferences(context: Context) {

    private val prefsName = "prefs"
    private val prefsKey = "isLoggedIn"
    private val prefs: SharedPreferences = context.getSharedPreferences(prefsName, 0)

    var isLoggedIn: String
        get() = prefs.getString(prefsKey, "").toString()
        set(value) = prefs.edit().putString(prefsKey, value).apply()
}