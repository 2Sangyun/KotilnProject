package com.example.kotilnproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "onCreate Called")
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}
    }

    private fun rollDice(){
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()

        val resultTextView : TextView = findViewById(R.id.result_text)
        resultTextView.text = "Dice Rolled!"
    }

    override fun onStart() {
        super.onStart()

        Log.i("MainActivity", "onStart Called")
    }

    override fun onResume() {
        super.onResume()

        Log.i("MainActivity", "onResume Called")
    }

    override fun onPause() {
        super.onPause()

        Log.i("MainActivity", "onPause Called")
    }

    override fun onStop() {
        super.onStop()

        Log.i("MainActivity", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("MainActivity", "onDestroy Called")
    }
}