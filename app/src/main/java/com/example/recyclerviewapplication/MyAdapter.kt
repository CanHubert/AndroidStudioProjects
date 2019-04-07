package com.example.recyclerviewapplication

import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewapplication.MainActivity.Companion.listaKontaktow
import com.example.recyclerviewapplication.MainActivity.Companion.listaNumerow
import kotlinx.android.synthetic.main.contact_row.view.*

class MyAdapter:RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val contactRow = layoutInflater.inflate(R.layout.contact_row, viewGroup, false)
        return MyViewHolder(contactRow)
    }

    override fun getItemCount(): Int {
        return listaKontaktow.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name = holder.view.contact_name
        val number = holder.view.contact_number
        val callBT = holder.view.Call_BT

        name.setText(listaKontaktow[position])
        number.setText(listaNumerow[position])

        callBT.setOnClickListener{
            val intent = Intent()
            intent.data = Uri.parse("tel:"+ listaNumerow[position])
            intent.action = Intent.ACTION_DIAL
            startActivity(holder.itemView.context, intent, null)
        }
    }
}


class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)