package com.example.donkey.Fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donkey.History
import com.example.donkey.MyAdapter
import com.example.donkey.R
import com.example.donkey.databinding.FragmentHistoryBinding
import java.util.ArrayList


class historyFragment : Fragment() {


    //------------------------- Recycler View ---------------------------------

    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<History>

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var news: Array<String>

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    var categories = arrayOf<String?>(
        "Bike Taxi"
//        , "Buy and Delivery", "Grocery and Food Delivery"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        binding.categoryspinner.adapter = activity?.applicationContext?.let {

            ArrayAdapter(it, R.layout.spinner_item, categories)
        } as SpinnerAdapter

        binding.categoryspinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    println("erreur")
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long,
                ) {
//                val type = parent?.getItemAtPosition(position).toString()
//                Toast.makeText(activity, type, Toast.LENGTH_LONG).show()
//                println(type)

//                (parent?.getChildAt(0) as? TextView)?.setTextColor(Color.GRAY)

                }

            }


        val mLayoutManager = LinearLayoutManager(context)
        binding.historyRecyclerview.layoutManager = mLayoutManager

        val historyData = ArrayList<History>()



        historyData.add(
            History(
                R.drawable.elipse,
                "chennai",
                "madurai",
                "bala",
                "₹" + "200",
                "booked",
                "bookingCategory"
            )
        )
        historyData.add(
            History(
                R.drawable.elipse,
                "bangalore",
                "dindugal",
                "rohit",
                "₹" + "500",
                "cancel",
                "taxi pp"
            )
        )

        historyData.add(
            History(
                R.drawable.elipse,
                "bangalore",
                "dindugal",
                "rohit",
                "₹" + "500",
                "cancel",
                "taxi pp"
            )
        )

        historyData.add(
            History(
                R.drawable.elipse,
                "bangalore",
                "dindugal",
                "rohit",
                "₹" + "500",
                "cancel",
                "taxi pp"
            )
        )

        historyData.add(
            History(
                R.drawable.elipse,
                "bangalore",
                "dindugal",
                "rohit",
                "₹" + "500",
                "cancel",
                "taxi pp"
            )
        )


        historyData.add(
            History(
                R.drawable.elipse,
                "bangalore",
                "dindugal",
                "rohit",
                "₹" + "500",
                "cancel",
                "taxi pp"
            )
        )


        val historyAdapter = MyAdapter(historyData)

        binding.historyRecyclerview.adapter = historyAdapter

        return binding.root
    }



    }

