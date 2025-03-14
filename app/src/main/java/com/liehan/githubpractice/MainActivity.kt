package com.liehan.githubpractice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //get the number and button element from the layout
        val input = findViewById<EditText>(R.id.edtNumber)
        val clickMe = findViewById<Button>(R.id.btnCheckNum)
        //set onClickListener for the button
        clickMe.setOnClickListener {
            //try catch statement to check if the input is a number
            try {
                //tries to turn the string into a number
                val numberInt = input.text.toString().toInt()
                //if the conversion succeeds, check if the number is even or odd
                // % is the modulo operator, which returns the remainder of the division
                if (numberInt % 2 == 0) {
                    Toast.makeText(this, "The number $numberInt is even", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "The number $numberInt is odd", Toast.LENGTH_LONG).show()
                }
                //if the conversion fails, show that the input is NaN
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "The input ${input.text} is not a number", Toast.LENGTH_LONG).show()
            }
        }
    }
}