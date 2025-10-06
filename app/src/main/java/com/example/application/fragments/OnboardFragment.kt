package com.example.application.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.application.R
import com.example.application.activity.MainActivity

class OnboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboard, container,false)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnRegister = view.findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener{
            val mainActivity = activity as? MainActivity
            mainActivity?.navigateToSignIn()
        }

        btnRegister.setOnClickListener{
            val mainActivity = activity as? MainActivity
            mainActivity?.navigateToSignUp()
        }
        return view
    }
}