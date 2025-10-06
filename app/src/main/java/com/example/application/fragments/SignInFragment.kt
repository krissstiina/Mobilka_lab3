package com.example.application.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.application.R
import com.example.application.activity.MainActivity

class SignInFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val tvSignUp = view.findViewById<TextView>(R.id.tvSignUp)

        val args = arguments
        if (args != null) {
            val email = args.getString("email", "")
            val name = args.getString("name", "")
            val lastName = args.getString("lastName", "")
            val age = args.getString("age", "")

            if (email.isNotEmpty()) {
                etEmail.setText(email)
                Toast.makeText(requireContext(), "Добро пожаловать, $name!", Toast.LENGTH_LONG).show()
            }
        }

        btnLogin.setOnClickListener{
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if(email.isNotEmpty() && password.isNotEmpty()){
                val mainActivity = activity as? MainActivity
                mainActivity?.navigateToHome()
            }
            else{
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }

        tvSignUp.setOnClickListener{
            val mainActivity = activity as? MainActivity
            mainActivity?.navigateToSignUp()
        }
        return view
    }
}