package com.example.recyclerviewapplication

import android.content.ContentResolver
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    companion object {
        val listaKontaktow = arrayListOf<String>()
        val listaNumerow = arrayListOf<String>()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MyAdapter()

        val contentResolver = contentResolver
        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null,null,null,null,null)

        try{
            cursor.moveToFirst()
            while (!cursor.isAfterLast){
                var id = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY))
                listaKontaktow.add(name)
                readPhoneNumber(contentResolver, id)
            }

        }finally {
            cursor.close()
        }

    }
}

fun readPhoneNumber(contentResolver: ContentResolver, id:String){

    val phoneCursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "= ?", arrayOf(id), null)

        if(phoneCursor.moveToFirst())
        {
            var number = phoneCursor.getString(
                phoneCursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
            MainActivity.listaNumerow.add(number)
        }
        else MainActivity.listaNumerow.add("Brak numeru")

    phoneCursor.close()
}