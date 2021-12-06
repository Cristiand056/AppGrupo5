package com.example.fitarmorapp.anim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fitarmorapp.R
import kotlinx.android.synthetic.main.fragment_splash.*


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        textBegining.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.splashFragment)
        }
        return view
    }


}