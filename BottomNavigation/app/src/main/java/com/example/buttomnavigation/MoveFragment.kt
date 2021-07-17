package com.example.buttomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoveFragment : Fragment() {

    lateinit var movebtn : Button

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.move_fragment, container, false)
        movebtn = view.findViewById(R.id.movebtn)

        movebtn.setOnClickListener {
            val homefrag = HomeFragment()

                val fragmentManagerv: FragmentManager
                val transaction : FragmentTransaction = parentFragmentManager!!.beginTransaction()
                transaction.replace(R.id.fragment_container, homefrag)
                transaction.commit()


        }

        return view
    }

}