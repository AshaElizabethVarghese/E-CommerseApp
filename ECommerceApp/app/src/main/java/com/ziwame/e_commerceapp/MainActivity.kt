package com.ziwame.e_commerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.ziwame.e_commerceapp.core.Constants
import androidx.navigation.findNavController
import com.ziwame.e_commerceapp.view.callback.OnFragmentActionListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),OnFragmentActionListener {
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = Constants.EMPTYSTRING

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cart -> {
                findNavController(R.id.MainContainer).navigate(R.id.cartFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }

    override fun onProgressBarLoad(visibility: Boolean) {
        when (visibility) {
            true -> showProgressBar()
            false -> hideProgressBar()
        }
    }
    fun showProgressBar() {
        progressWrapper.visibility = View.VISIBLE
        circleLoader.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progressWrapper.visibility = View.GONE
        circleLoader.visibility = View.GONE
    }
}