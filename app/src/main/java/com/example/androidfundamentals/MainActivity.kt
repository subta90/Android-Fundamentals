package com.example.androidfundamentals

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val extraMessage = "com.example.android.androidfundamentals.extra.MESSAGE"
        const val textRequest = 1
    }

    private val logTag = MainActivity::class.java.simpleName
    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyHeaderTextView: TextView
    private lateinit var mReplyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(logTag, "-------")
        Log.d(logTag, "onCreate")
        setContentView(R.layout.activity_main)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeaderTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)

        savedInstanceState?.let {
            val isVisible = savedInstanceState.getBoolean("reply_visible")

            Log.d(logTag,"savedInstanceState enabled")
            if (isVisible) {
                mReplyTextView.visibility = View.VISIBLE
                mReplyHeaderTextView.visibility = View.VISIBLE

                val text = savedInstanceState.getString("reply_text")
                mReplyTextView.text = text
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(logTag, "onSaveInstanceState")
        if (mReplyHeaderTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", mReplyTextView.text.toString())
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logTag, "onRestart")
    }

    override fun onStop() {3
        super.onStop()
        Log.d(logTag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "onDestroy")
    }

    fun launchSecondActivity(view: View) {
        Log.d(logTag, "Button Clicked!")

        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(extraMessage, message)
        startActivityForResult(intent, textRequest)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            textRequest -> {
                if (resultCode == Activity.RESULT_OK) {
                    val reply = data?.getStringExtra(SecondActivity.extraReply)
                    mReplyHeaderTextView.visibility = View.VISIBLE
                    mReplyTextView.visibility = View.VISIBLE
                    mReplyTextView.text = reply
                }
            }
            else -> {

            }

        }
    }
}
