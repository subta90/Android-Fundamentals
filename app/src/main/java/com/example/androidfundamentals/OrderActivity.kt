package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intent = getIntent()
        val message = "Order: " + intent.getStringExtra(MainActivity.extraMessage)
        val textView = findViewById<TextView>(R.id.order_textview)
        textView.text = message
    }

    fun onRadioButtonClicked(view: View) {
        if (view !is RadioButton) return
        val checked = view.isChecked

        when (view.id) {
            R.id.sameday ->
                if (checked) {
                    displayToast(getString(R.string.same_day_messenger_service))
                }

            R.id.nextday ->
                if (checked) {
                    displayToast(getString(R.string.next_day_ground_delivery))
                }

            R.id.pickup ->
                if (checked) {
                    displayToast(getString(R.string.pick_up))
                }

        }
    }

    fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
