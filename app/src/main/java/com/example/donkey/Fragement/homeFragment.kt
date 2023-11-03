package com.example.donkey.Fragement

import HorizontalAdapter
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donkey.R
import com.example.donkey.horizontal


class homeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView!!.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val horizontal = listOf(
            horizontal("offer 1","get now"),
            horizontal("offer 2","get now"),
            horizontal("offer 3","get now")
        )

        val adapter = HorizontalAdapter(horizontal)

        recyclerView!!.adapter = adapter

        return view

    }
}



