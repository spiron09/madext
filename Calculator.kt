package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    //add  implementation  'net.objecthunter:exp4j:0.4.8' to build.graddle
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var plus: Button
    lateinit var equal: Button
    lateinit var exp: TextView
    lateinit var result: TextView
    lateinit var clear: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        plus = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)
        exp = findViewById(R.id.exp)
        result = findViewById(R.id.result)
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

        equal.setOnClickListener {
            try {
                val e = exp.text.toString()
                val ep = ExpressionBuilder(e).build();
                val exp = ep.evaluate().toDouble()
                result.text = exp.toString();

            }
            catch (e:Exception){
                result.text = "Error"
            }
        }
    }

    private fun pressButton(s: String) {
        exp.append(s)
    }
}