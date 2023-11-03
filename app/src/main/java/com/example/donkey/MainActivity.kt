package com.example.donkey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.donkey.Fragement.historyFragment
import com.example.donkey.Fragement.homeFragment
import com.example.donkey.Fragement.offerFragment
import com.example.donkey.Fragement.profileFragment
import com.example.donkey.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var activeFragment: Fragment? = null
    private lateinit var fragmentManager: FragmentManager
    private val homeFragment = homeFragment()
    private val offerFragment = offerFragment()
    private lateinit var fragementmain : FrameLayout
    private val historyFragment = historyFragment()
    private val profileFragment = profileFragment()

    lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragementmain = findViewById(R.id.fragementmain)
        fragmentManager = supportFragmentManager


        activeFragment = homeFragment
        fragmentManager.beginTransaction().add(R.id.fragementmain, activeFragment!!).commit()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnav)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    switchFragment(homeFragment)
                    true
                }
                R.id.navigation_offer -> {
                    switchFragment(offerFragment)
                    true
                }
                R.id.navigation_history -> {
                    switchFragment(historyFragment)
                    true
                }
                R.id.navigation_profile -> {
                    switchFragment(profileFragment)
                    true
                }
                else -> false
            }
        }


    }

    private fun switchFragment(fragment: Fragment) {

        if (fragment != activeFragment) {
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            if (activeFragment != null) {
                transaction.hide(activeFragment!!)
            }
            if (fragment.isAdded) {
                transaction.show(fragment)
            } else {
                transaction.add(R.id.fragementmain, fragment)
            }
            transaction.commit()
            activeFragment = fragment
        }

    }
}


