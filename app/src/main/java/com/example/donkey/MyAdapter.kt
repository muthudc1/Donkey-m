package com.example.donkey


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter ( private val newsList : ArrayList<History>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.history_design, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user = newsList[position]

        holder.titleImage.setImageResource(user.titleImage)
        holder.driverName.text = user.driverName
        holder.tripPrice.text = user.tripPrice
        holder.pickupLocation.text = user.pickupLocation
        holder.dropOffLocation.text = user.dropOffLocation
        holder.bookingStatus.text = user.bookingStatus
        holder.bookingCategory.text = user.bookingCategory

        val context = holder.historyCardView.context

        if (holder.bookingStatus.text == "Searching For The Driver")    // - 0
        {
            holder.bookingStatus.setTextColor(Color.parseColor("#0E7596"))
        }

        else if (holder.bookingStatus.text == "Driver Has Accepted the Order And He is On The Way") // - 1
        {
            holder.bookingStatus.text = "Driver is on the way"
            holder.bookingStatus.setTextColor(Color.parseColor("#0E7596"))
        }

        else if (holder.bookingStatus.text == "Booking Has Been Completed")     // - 2
        {
            holder.bookingStatus.setTextColor(Color.parseColor("#79B602"))
        }

        else if (holder.bookingStatus.text == "Your Ride Has Started")      // - 3
        {
            holder.bookingStatus.setTextColor(Color.parseColor("#0E7596"))
        }

        else if (holder.bookingStatus.text == "Booking has Been Cancelled")     // - 4
        {
            holder.bookingStatus.setTextColor(Color.parseColor("#FF7575"))
        }

//        check booking category text
        if (holder.bookingCategory.text == "1")
        {
            holder.bookingCategory.text = "Bike Taxi"
        }
        else if (holder.bookingCategory.text == "2")
        {
            holder.bookingCategory.text = "Multi Booking"
        }
        else if (holder.bookingCategory.text == "3")
        {
            holder.bookingCategory.text = "Buy and Delivery"
        }


        holder.historyCardView.setOnClickListener {

//            if(holder.bookingCategory.text == "Bike Taxi")
//            {

                if (holder.bookingStatus.text == "Searching For The Driver")    // - 0
                {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }

                else if (holder.bookingStatus.text == "Driver is on the way") // - 1
                {

                    val bundleSecond = Bundle()
                    bundleSecond.putString("driverAccepted", "Accepted")

                    val intent = Intent(context, MainActivity::class.java)
                    intent.putExtras(bundleSecond)
                    context.startActivity(intent)
                }

                else if (holder.bookingStatus.text == "Booking Has Been Completed")     // - 2
                {

                    val bundle = Bundle()
                    bundle.putString("driverName", holder.driverName.text.toString())
                    bundle.putString("fromLocation", holder.pickupLocation.text.toString())
                    bundle.putString("toLocation", holder.dropOffLocation.text.toString())
                    bundle.putString("totalPrice", holder.tripPrice.text.toString())

                    val intent = Intent(context, MainActivity::class.java)
                    intent.putExtras(bundle)
                    context.startActivity(intent)
                }

                else if (holder.bookingStatus.text == "Your Ride Has Started")      // - 3
                {
                    val bundleSecond = Bundle()
                    bundleSecond.putString("driverAccepted", "Started")

                    val intent = Intent(context, MainActivity::class.java)
                    intent.putExtras(bundleSecond)
                    context.startActivity(intent)
                }

                else if (holder.bookingStatus.text == "Booking has Been Cancelled")     // - 4
                {

                }

//            }

//            else if (holder.bookingCategory.text == "Buy and Delivery")
//            {
//                val intent = Intent(context,  buydeliveryCategory::class.java)
//                context.startActivity(intent)
//            }
        }

    }

    override fun getItemCount(): Int {

        return newsList.size

    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {

            val titleImage : ImageView = itemView.findViewById(R.id.title_Image)
            val driverName : TextView = itemView.findViewById(R.id.driverName)
            val pickupLocation : TextView = itemView.findViewById(R.id.pickupLocation)
            val dropOffLocation : TextView = itemView.findViewById(R.id.dropOffLocation)
            val tripPrice : TextView = itemView.findViewById(R.id.tripPrice)
            val bookingStatus : TextView = itemView.findViewById(R.id.bookingStatus)
            val bookingCategory : TextView = itemView.findViewById(R.id.bookingCategory)
            val historyCardView: CardView = itemView.findViewById(R.id.historyCardview)

    }

}