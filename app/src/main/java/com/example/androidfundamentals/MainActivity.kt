package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var mScore1 = 0
    private var mScore2 = 0

    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)
    }

    fun decreaseScore(view: View) {
        when (view.id) {

            R.id.decreaseTeam1 -> {
                mScore1--
                mScoreText1.text = mScore1.toString()
            }

            R.id.decreaseTeam2 -> {
                mScore2--
                mScoreText2.text = mScore2.toString()
            }

        }
    }


    fun increaseScore(view: View) {
        when (view.id) {

            R.id.increaseTeam1 -> {
                mScore1++
                mScoreText1.text = mScore1.toString()
            }

            R.id.increaseTeam2 -> {
                mScore2++
                mScoreText2.text = mScore2.toString()
            }

        }
    }
}
