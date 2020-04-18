package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intent = getIntent()
        val message = "Order: " + intent.getStringExtra(MainActivity.extraMessage)
        val textView = findViewById<TextView>(R.id.order_textview)
        textView.text = message
    }
}
