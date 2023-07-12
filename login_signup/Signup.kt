package com.example.signup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var signupuname: EditText
    lateinit var signuppass: EditText
    lateinit var signupbut: Button
    val re = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#\$%^&*]{8,}$"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signupuname = findViewById(R.id.signupuname)
        signuppass = findViewById(R.id.signuppass)
        signupbut = findViewById(R.id.signupbut)

        signupbut.setOnClickListener{
            getDetails()
        }
    }

    private fun getDetails() {
        val uname: String = signupuname.text.toString()
        val pass: String = signuppass.text.toString()

        if(validate(pass)){
            Toast.makeText(this, "Sign Up is Succesfull", Toast.LENGTH_SHORT).show()

            val bundle = Bundle()
            bundle.putString("uname", uname)
            bundle.putString("pass", pass)

            val intent = Intent(this, login::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        else {
            Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validate (pass:String) : Boolean {
        val pattern: Pattern = Pattern.compile(re)
        val matcher: Matcher = pattern.matcher(pass)

        return matcher.matches()
    }
}