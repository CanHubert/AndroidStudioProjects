package com.example.firstapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
import org.w3c.dom.Text

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        menageEditEmail(e_mail, mail_warn)
        menageEditPassword(password, password_warn)
/*
        set_sex_RG.setOnCheckedChangeListener{ group, checkedId ->
            run{
                val activationIntence: Intent = Intent(applicationContext, MainActivity::class.java)
                var RB: RadioButton = findViewById(checkedId)
                activationIntence.putExtra("plec", RB.text)
                startActivity(activationIntence)
            }

        }
        */
    }

    fun submitData(view: View){

        if(!regulations_CHB.isChecked)
            Toast.makeText(applicationContext, "Proszę potwierdzić regulamin", Toast.LENGTH_SHORT).show()

        else{
            val intent = Intent(applicationContext, ProfileActivity::class.java)
            intent.putExtra("login", login.text)
            intent.putExtra("password", password.text)
            intent.putExtra("email", e_mail.text)
            intent.putExtra("plec",  findViewById<RadioButton>(set_sex_RG.checkedRadioButtonId).text)

            var newsletterAnswer:String
            if(newsletter.isChecked) newsletterAnswer= "TAK"
            else newsletterAnswer =  "Nie"

            intent.putExtra("newsletter", newsletterAnswer)
            startActivity(intent)
        }
    }
}
