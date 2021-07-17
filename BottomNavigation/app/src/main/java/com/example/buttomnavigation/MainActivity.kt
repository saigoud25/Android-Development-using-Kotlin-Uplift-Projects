package com.example.buttomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        var homefrag = HomeFragment()
        var camfrag = CameraFragment()
        var movefrag = MoveFragment()
        var userfrag = UserFragment()

        setCurrentFragment(homefrag)


        bottomNavigationView.setOnItemSelectedListener{

            when(it.itemId)
            {
                R.id.home -> setCurrentFragment(homefrag)
                R.id.move -> setCurrentFragment(movefrag)
                R.id.camera -> setCurrentFragment(camfrag)
                R.id.user -> setCurrentFragment(userfrag)
            }
            true
        }

    }



    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}