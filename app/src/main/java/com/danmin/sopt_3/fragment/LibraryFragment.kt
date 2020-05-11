package com.danmin.sopt_3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.danmin.sopt_3.R
import com.danmin.sopt_3.bookRecycler.BookAdapter
import com.danmin.sopt_3.bookRecycler.BookData
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {
    lateinit var bookAdapter: BookAdapter
    val datas = mutableListOf<BookData>()

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
            layoutManager = GridLayoutManager(view.context, 3)
        }
        loadDatas()
    }

    private fun loadDatas() {
        datas.apply {
            add(
                BookData(
                    title = "이정민",
                    book_img = "https://avatars1.githubusercontent.com/u/50590192?s=460&u=e6a104455a4e61cb4b4693e1be8debc48bb955f6&v=4"
                )
            )
            add(
                BookData(
                    title = "이정민",
                    book_img = "https://avatars1.githubusercontent.com/u/50590192?s=460&u=e6a104455a4e61cb4b4693e1be8debc48bb955f6&v=4"
                )
            )
            add(
                BookData(
                    title = "이정민",
                    book_img = "https://avatars1.githubusercontent.com/u/50590192?s=460&u=e6a104455a4e61cb4b4693e1be8debc48bb955f6&v=4"
                )
            )
        }
        bookAdapter.datas = datas
        bookAdapter.notifyDataSetChanged()
    }
}