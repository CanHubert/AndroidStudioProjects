package com.example.firstapp

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

    fun menageEditPassword(password:EditText, password_warn: TextView){
        password.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                if(password.length() == 0 ) password_warn.visibility = TextView.INVISIBLE
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(password.length() <= 6)
                {
                    password_warn.setText("Hasło za krótkie!")

                }
                else
                {
                    password_warn.setText("Prawie Enigma!")
                }
                password_warn.visibility = TextView.VISIBLE
            }
        })
    }

    fun menageEditEmail(e_mail:EditText, mail_warn: TextView){
        e_mail.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if(e_mail.length() == 0) mail_warn.visibility = TextView.INVISIBLE
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                mail_warn.setText("Nie poprawny email!")

                for(i in e_mail.text )
                {
                    if(i == '@')
                    {
                        mail_warn.setText("Poprawny email!")
                    }
                }
                mail_warn.visibility = TextView.VISIBLE
            }
        })
    }

