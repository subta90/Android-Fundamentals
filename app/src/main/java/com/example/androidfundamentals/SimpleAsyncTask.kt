package com.example.androidfundamentals

import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference
import kotlin.random.Random

class SimpleAsyncTask(textView: TextView) : AsyncTask<Void, Void, String>() {

    private val mTextView: WeakReference<TextView> = WeakReference(textView)

    override fun doInBackground(vararg p0: Void?): String {
        val random = Random(1)
        val n = random.nextInt(11)

        val s: Long = (n * 1000).toLong()

        try {
            Thread.sleep(s)

        } catch (e: InterruptedException) {
            e.printStackTrace()

        }

        return "Awake at last after sleeping for $s milliseconds!"
    }

    override fun onPostExecute(result: String?) {
        mTextView.get()?.text = result
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }
}