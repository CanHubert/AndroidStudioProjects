package com.example.firstapp

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_second.*

class ProfileActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    override fun onResume() {
        super.onResume()
        if(intent.hasExtra("login")) Login_Info.setText("Login: " +intent.getCharSequenceExtra("login"))
        if(intent.hasExtra("password")) Password_Info.setText("Password: " +intent.getCharSequenceExtra("password"))
        if(intent.hasExtra("email")) Email_Info.setText("Email: " +intent.getCharSequenceExtra("email"))
        if(intent.hasExtra("newsletter")) Newsletter_Info.setText("Newsletter: " +intent.getCharSequenceExtra("newsletter"))
        if(intent.hasExtra("plec")) Sex_Info.setText("Płeć: " + intent.getCharSequenceExtra("plec"))


    }
}
