package com.danmin.sopt_3.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danmin.sopt_3.LoginActivity
import com.danmin.sopt_3.MySharedPreferences
import com.danmin.sopt_3.R
import kotlinx.android.synthetic.main.fragment_mypage.*

class MypageFragment : Fragment() {

    private lateinit var isLoggedIn: MySharedPreferences

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isLoggedIn = MySharedPreferences(this.context!!)

        logout_btn.setOnClickListener {
            isLoggedIn.isLoggedIn = "isLoggedOut"
            val intent = Intent(this.context, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
