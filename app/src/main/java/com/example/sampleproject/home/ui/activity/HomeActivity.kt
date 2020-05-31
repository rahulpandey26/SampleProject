package com.example.sampleproject.home.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.R
import com.example.sampleproject.common.util.FragmentHelper
import com.example.sampleproject.home.ui.fragment.HomeFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadHomeFragment()
    }

    private fun loadHomeFragment() {
        FragmentHelper.replaceFragment(this, HomeFragment(), R.id.fragment_container,
            "home_fragment")
    }
}
