package com.danmin.sopt_3.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.danmin.sopt_3.R
import com.danmin.sopt_3.bookRecycler.BookAdapter
import com.danmin.sopt_3.data.ResponseBook
import com.danmin.sopt_3.data.ResponseBookData
import com.danmin.sopt_3.network.RequestBookToServer
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.item_book.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LibraryFragment : Fragment() {
    lateinit var bookAdapter: BookAdapter
    val datas = mutableListOf<ResponseBookData>()

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

        val requestToServer = RequestBookToServer

        val context = this.activity

        search_button.setOnClickListener {
            if (search_book.text.toString() == "") {
                Toast.makeText(context, "책 제목을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                // search request
                requestToServer.service.requestBook(
                    title = search_book.text.toString()
                ).enqueue(object : Callback<ResponseBook> {
                    override fun onFailure(call: Call<ResponseBook>, t: Throwable) {
                        // fail
                        Log.e("error", t.toString())
                        Toast.makeText(context, "책 정보 가져오기 실패", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<ResponseBook>,
                        response: Response<ResponseBook>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("res",response.toString())
                            Log.d("data",response.body().toString())
                            response.body()!!.documents.map {
                                Log.d("data",it.toString())
                                datas.apply {
                                    add(
                                        it
                                    )
                                }
                                bookAdapter.datas = datas
                                bookAdapter.notifyDataSetChanged()
                            }
                        }
                    }
                })
            }
        }
    }
}