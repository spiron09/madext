package com.example.xml_json

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var temperature: TextView
    private lateinit var xmlbutton: Button
    private lateinit var jsonbutton: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temperature = findViewById(R.id.temp);
        xmlbutton = findViewById(R.id.xmlbut);
        jsonbutton = findViewById(R.id.jsonbut);

        xmlbutton.setOnClickListener{parseXML()}
        jsonbutton.setOnClickListener{parseJSON()}

    }

    private fun parseXML(){
        val input = assets.open("myxml.xml")
        val dbf = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input)
//        val docbuild = dbf.newDocumentBuilder()
//        val doc = docbuild.parse(input)
        temperature.text = dbf.getElementsByTagName("temperature").item(0).firstChild.nodeValue
    }

    private fun parseJSON(){
        val obj = JSONObject(jparse());
        temperature.text = obj.getString("temperature")
    }

    private fun jparse () : String {
        val json: String
        try {
            val input = assets.open("myjson.json")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            val charset: Charset = Charsets.UTF_8
            json = String(buffer, charset)
        }

        catch (ex: IOException){
            return ""
        }
        return json
    }
}