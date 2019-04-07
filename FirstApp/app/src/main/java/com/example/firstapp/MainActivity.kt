package com.example.firstapp

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       Donate.setOnClickListener{
           var message = Toast.makeText(applicationContext,"Gratulacje! Dobra decyzja!", Toast.LENGTH_SHORT)
           message.show()

           var adress = "https://www.youtube.com/watch?v=N7ch-RVO1sA&index=4&list=PL7i9G1Htb_PvSiltEra3FJM41sjBy7YBb"
           var channel = Intent(ACTION_VIEW, Uri.parse(adress))
           startActivity(channel)
       }

        Request.setOnClickListener{
            var message = Toast.makeText(applicationContext,"Dziękuję!", Toast.LENGTH_LONG)
            message.show()

            //Tworzymy nowa aktywnosc odpalajaca secondActivity
            var newActivity : Intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(newActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        if(intent.hasExtra("plec"))
        {
            sexId.setText(intent.getCharSequenceExtra("plec"))

        }
    }

}
