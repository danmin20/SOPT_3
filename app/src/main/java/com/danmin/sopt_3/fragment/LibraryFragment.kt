package com.danmin.sopt_3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.danmin.sopt_3.R
import com.danmin.sopt_3.bookRecycler.BookAdapter
import com.danmin.sopt_3.data.ResponseBook
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {
    lateinit var bookAdapter: BookAdapter
    val datas = mutableListOf<ResponseBook>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookAdapter = BookAdapter(view.context)
        rv_book.run {
            adapter = bookAdapter
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        }
    }

    join_btn.setOnClickListener
    {
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