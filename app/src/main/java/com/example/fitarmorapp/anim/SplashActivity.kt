package com.example.fitarmorapp.anim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.FragmentNavigator
import com.example.fitarmorapp.R
import com.example.fitarmorapp.activitys.AuthActivity


class SplashActivity : AppCompatActivity() {

    private val time:Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        },time)









    }
}