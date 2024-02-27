package com.cere.example

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.cere.core.base.BaseActivity
import com.cere.example.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewBinding(content: View): ActivityMainBinding {
        TODO("Not yet implemented")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.setting -> {
                Snackbar.make(rootView, "设置", Snackbar.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}