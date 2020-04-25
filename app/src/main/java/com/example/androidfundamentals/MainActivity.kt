package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var mScore1 = 0
    private var mScore2 = 0

    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView

    private val stateScore1 = "Team 1 Score"
    private val stateScore2 = "Team 2 Score"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)

        mScore1 = savedInstanceState?.getInt(stateScore1) ?: 0
        mScore2 = savedInstanceState?.getInt(stateScore2) ?: 0

        mScoreText1.text = mScore1.toString()
        mScoreText2.text = mScore2.toString()

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


    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("debug", "onSavedInstanceState")
        outState.putInt(stateScore1, mScore1)
        outState.putInt(stateScore2, mScore2)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        when (AppCompatDelegate.getDefaultNightMode()) {

            AppCompatDelegate.MODE_NIGHT_YES -> {
                menu?.findItem(R.id.night_mode)?.title = resources.getString(R.string.day_mode)
            }

            else -> {
                menu?.findItem(R.id.night_mode)?.title = resources.getString(R.string.night_mode)
            }

        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.night_mode) {

            when (AppCompatDelegate.getDefaultNightMode()) {

                AppCompatDelegate.MODE_NIGHT_YES -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }

                else -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }

            recreate()

        }

        return super.onOptionsItemSelected(item)
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
