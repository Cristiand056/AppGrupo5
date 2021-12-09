package com.example.fitarmorapp.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.fitarmorapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpButtonR.setOnClickListener{
            if (editTextEmailSign.text.isNotEmpty() && editTextPasswordSign1.text.isNotEmpty() && editTextPasswordSign2.text.isNotEmpty()){
                if(editTextPasswordSign1.text.toString()==editTextPasswordSign2.text.toString()){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(editTextEmailSign.text.toString(), editTextPasswordSign1.text.toString()).addOnCompleteListener(){
                        if(it.isSuccessful){
                            comeBackToAuth()
                        }
                        else{
                            showAlertUserSign()
                        }
                    }

                }else{
                    showAlertPasswordSign()
                }
            }else{
                showAlertSignUp()
            }
        }
        cancelButtonSign.setOnClickListener{
            comeBackToAuth()
        }
    }

    private fun comeBackToAuth() {
        val authIntent = Intent(this,AuthActivity::class.java)
        startActivity(authIntent)
    }

    private fun showAlertSignUp() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Campos vacios, complete los capos por favor Email y passwords")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun showAlertPasswordSign() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Las contraseñas no considen")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private  fun showAlertUserSign(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("El usuario ya existe")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
