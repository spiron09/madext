package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var start: Button
    lateinit var stop: Button
    lateinit var reset: Button
    lateinit var counter: TextView
    val timer = Mycounter(100000, 1000)
    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start = findViewById(R.id.startbtn)
        stop = findViewById(R.id.stopbtn)
        reset = findViewById(R.id.resetbtn)
        counter = findViewById(R.id.counter)

        start.setOnClickListener {
            timer.start()
            start.isEnabled = false
        }

        stop.setOnClickListener {
            timer.cancel()
            start.isEnabled = true
        }

        reset.setOnClickListener {
            timer.cancel()
            start.isEnabled = true
            count = 0
            counter.text = count.toString()
        }


    }

    inner class Mycounter(x : Long, y:Long) : CountDownTimer(x,y) {

        override fun onTick(p0: Long) {
            count++
            counter.text = count.toString()
        }

        override fun onFinish() {
            counter.text = "Done"
        }
    }
}