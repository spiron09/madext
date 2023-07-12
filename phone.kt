package com.example.phone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var plus: Button
    lateinit var save: Button
    lateinit var call: Button
    lateinit var clear: Button
    lateinit var phone: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Put these lines in manifest
        <uses-permission android:name="android.permission.READ_CONTACTS"></uses-permission>
    <uses-permission android:name="android.permission.WRITE_CONTACTS"></uses-permission>
    <uses-permission android:name="android.permission.CALL_PHONE"></uses-permission>*/
        
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        plus = findViewById(R.id.plus)
        save = findViewById(R.id.save)
        phone = findViewById(R.id.number)
        call = findViewById(R.id.call)
        clear = findViewById(R.id.clear)
        one.setOnClickListener {
            pressButton("1")
        }

        two.setOnClickListener {
            pressButton("2")
        }

        three.setOnClickListener {
            pressButton("3")
        }

        plus.setOnClickListener {
            pressButton("+")
        }

        clear.setOnClickListener {
            phone.text = ""
        }

        save.setOnClickListener {
            val intent =  Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+phone.text))
            intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE, true)
            startActivity(intent)

        }

        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone.text))
            startActivity(intent)
        }

    }

    private fun pressButton(s: String) {
        phone.append(s)
    }
}
