package com.danmin.sopt_3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var isLoggedIn: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        isLoggedIn = MySharedPreferences(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            if (login_email.text.isNullOrBlank() || login_pw.text.isNullOrBlank()) {
                Toast.makeText(this, "이메일과 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                isLoggedIn.isLoggedIn = "isLoggedIn"
                finish()
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
                    val savedEmail = data?.getStringExtra("email").toString()
                    login_email.setText(savedEmail)
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