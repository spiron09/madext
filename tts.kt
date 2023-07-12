package com.example.tts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.Locale
import java.util.Queue

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var textip: EditText
    private lateinit var speak : Button
    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textip = findViewById(R.id.textip)
        speak = findViewById(R.id.speak)
        tts = TextToSpeech(this,this)

        speak.setOnClickListener { converttospeech() }
    }

    override fun onInit(status: Int){
        if(status == TextToSpeech.SUCCESS){
            val result = tts.setLanguage(Locale.US)
        }
        else {
            Log.e("TTS", "Failed")
        }
    }

    private fun converttospeech(){
        val text = textip.text.toString()
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
        Toast.makeText(this, "Spoken", Toast.LENGTH_SHORT).show();
    }

}