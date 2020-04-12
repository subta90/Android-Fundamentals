package com.example.androidfundamentals

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.app.ShareCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mWebsiteEditText: EditText
    private lateinit var mLocationEditText: EditText
    private lateinit var mShareTextEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)
    }

    fun openWebsite(view: View) {
        val urlString = mWebsiteEditText.text.toString()
        val url = Uri.parse(urlString)

        val intent = Intent(Intent.ACTION_VIEW, url)
        intent.resolveActivity(packageManager).let {
            startActivity(intent)
        }
    }

    fun openLocation(view: View) {
        val locationString = mLocationEditText.text.toString()
        val addressUri = Uri.parse("geo:0, 0?q=" + locationString)

        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        intent.resolveActivity(packageManager).let {
            startActivity(intent)
        }
    }

    fun shareText(view: View) {
        val shareTextString = mShareTextEditText.text.toString()
        val mimeType = "text/plain"

        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share this text with: ")
            .setText(shareTextString)
            .startChooser()
    }
}
