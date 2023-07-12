package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate

class login : AppCompatActivity() {
    lateinit var loginuname: EditText
    lateinit var loginpass: EditText
    lateinit var loginbut: Button
    var count: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginuname = findViewById(R.id.loginuname)
        loginpass = findViewById(R.id.loginpass)
        loginbut = findViewById(R.id.loginbut)

        val bundle: Bundle? = intent.extras
        val uname: String? = bundle?.getString("uname")
        val pass: String? = bundle?.getString("pass")

        loginbut.setOnClickListener{
            validate(uname, pass)
        }


    }

    private fun validate(uname: String?, pass: String?){
       val uname_ent = loginuname.text.toString()
        val pass_ent = loginpass.text.toString()

        if(uname_ent == uname && pass_ent == pass){
            Toast.makeText(this, "Succ", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, welcome::class.java)
            startActivity(intent)
        }
        else{
            count++;
            if(count>3){
                loginbut.isEnabled = false

                //toast
            }

            else{
                //toast
            }
        }
    }
}