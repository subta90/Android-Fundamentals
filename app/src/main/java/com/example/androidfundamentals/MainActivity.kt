package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mTextView: TextView
    private val textState = "currentText"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.textView1)
        mTextView.text = savedInstanceState?.getString(textState) ?: getString(R.string.start_text)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(textState, mTextView.text.toString())
    }

    fun startTask(view: View) {
        mTextView.text = (getString(R.string.napping))
        SimpleAsyncTask(mTextView).execute()
    }
}
