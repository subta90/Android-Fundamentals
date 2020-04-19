package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intent = getIntent()
        val message = "Order: " + intent.getStringExtra(MainActivity.extraMessage)
        val textView = findViewById<TextView>(R.id.order_textview)
        textView.text = message

        val spinner = findViewById<Spinner>(R.id.label_spinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerLabel = p0?.getItemAtPosition(p2).toString()
                displayToast(spinnerLabel)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        val adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

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


