package com.example.wallp

import android.app.WallpaperManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var mywall: Array<Int> = arrayOf( R.drawable.wall1, R.drawable.wall2);
    private lateinit var changewallpaper: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changewallpaper = findViewById(R.id.Button)
        changewallpaper.setOnClickListener { setwallpaper() }


    }

    private fun setwallpaper() {
        Toast.makeText(this, "Setting wallpaper please wait", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(
            {
                for(i in mywall){
                    val manager = WallpaperManager.getInstance(baseContext)
                    manager.setResource(i)
                    Thread.sleep(3000)
                }
            }
            ,4000)

    }

}