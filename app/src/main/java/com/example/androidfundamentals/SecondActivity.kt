package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    companion object {
        const val extraReply = "com.example.android.androidfundamentals.extra.REPLY"
    }

    private lateinit var mReply: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val message = intent.getStringExtra(MainActivity.extraMessage)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message

        mReply = findViewById(R.id.editText_second)
    }

    fun returnReply(view: View) {
        val reply = mReply.text.toString()

        val replyIntent = Intent()
        replyIntent.putExtra(extraReply, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}
