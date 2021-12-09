package com.example.fitarmorapp.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.appcompat.app.AlertDialog
import com.example.fitarmorapp.R
import kotlinx.android.synthetic.main.activity_auth.*
import com.example.fitarmorapp.databinding.ActivityAuthBinding

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth



class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intentHome = Intent(this, MainActivity::class.java)

        //analitycs
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","integración con firebase completa")
        analytics.logEvent("InitScreen",bundle)

        loginButton.setOnClickListener{
            if(editTextEmail.text.isNotEmpty() && editTextPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(editTextEmail.text.toString(),editTextPassword.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                        startActivity(intentHome)
                    }
                    else
                    {
                        showAlert2()
                    }
                }



            }else{
                showAlert()
            }
        }

        signUpButton.setOnClickListener{
            showSignUp()
        }
    }


    private fun showAlert2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Error en loggear usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


    private fun showSignUp() {
        val signUptent = Intent(this, SignUpActivity::class.java)
        startActivity(signUptent)
    }


    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Campos Erroneos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}