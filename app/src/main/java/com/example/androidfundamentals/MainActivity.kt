package com.example.androidfundamentals

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var mWebsiteEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWebsiteEditText = findViewById(R.id.website_edittext)
    }

    fun openWebsite(view: View) {
        val urlString = mWebsiteEditText.text.toString()
        val url = Uri.parse(urlString)

        val intent = Intent(Intent.ACTION_VIEW, url)
        intent.resolveActivity(packageManager).let {
            startActivity(intent)
        }

    }

    fun openLocation(view: View) {}

    fun shareText(view: View) {}
}
