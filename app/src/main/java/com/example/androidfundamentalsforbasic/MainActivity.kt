package com.example.androidfundamentalsforbasic

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mWordList: LinkedList<String> = LinkedList()

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val wordListSize = mWordList.size
            mWordList.addLast("+ Word $wordListSize")
            mRecyclerView.adapter?.notifyItemInserted(wordListSize)
            mRecyclerView.smoothScrollToPosition(wordListSize)
        }

        for (i in 0..19) {
            mWordList.addLast("Word: $i")
        }

        mRecyclerView = findViewById(R.id.recyclerview)
        mAdapter = WordListAdapter(this, mWordList)

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_reset -> {
                deleteAddedWords()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteAddedWords() {

        mWordList.size > 20

        for (i in 20 until mWordList.size) {
            mWordList.removeLast()
            mRecyclerView.adapter?.notifyItemRemoved(mWordList.size)
        }
    }

}
