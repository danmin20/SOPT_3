package com.danmin.sopt_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        join_btn.setOnClickListener {
            if (join_email.text.isNullOrBlank() || join_pw.text.isNullOrBlank()) {
                Toast.makeText(this, "이메일과 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show()
            } else if (join_check_pw.text.toString() != join_pw.text.toString()) {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("email", join_email.text.toString())
                intent.putExtra("password", join_pw.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
