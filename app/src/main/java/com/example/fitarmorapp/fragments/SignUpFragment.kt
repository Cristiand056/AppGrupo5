package com.example.fitarmorapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitarmorapp.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_sign_up.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","integración con firebase completa")
        analytics.logEvent("InitScreen",bundle)

        //buttons

        signUpButtonR.setOnClickListener{
            if (editTextEmailSign.text.isNotEmpty() && editTextPasswordSign1.text.isNotEmpty() && editTextPasswordSign2.text.isNotEmpty()){
                if(editTextPasswordSign1.text.toString()==editTextPasswordSign2.text.toString()){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(editTextEmailSign.text.toString(), editTextPasswordSign1.text.toString()).addOnCompleteListener(){
                        if(it.isSuccessful){
                            showLoginSign(it.result?.user?.email?:"",ProviderType.BASIC)
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


        return view
    }

    private fun comeBackToAuth() {
        TODO("Not yet implemented")
    }

    private fun showAlertSignUp() {
        TODO("Not yet implemented")
    }

    private fun showLoginSign(s: String, basic: Any) {

    }
    private fun showAlertUserSign(){

    }
    private fun showAlertPasswordSign(){

    }


}