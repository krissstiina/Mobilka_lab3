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

class RegistrFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registr, container, false)

        val etFirstName = view.findViewById<EditText>(R.id.etFirstName)
        val etLastName = view.findViewById<EditText>(R.id.etLastName)
        val etAge = view.findViewById<EditText>(R.id.etAge)
        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val etConfirm = view.findViewById<EditText>(R.id.etConfirmPassword)
        val btnRegister = view.findViewById<Button>(R.id.btnSignUp)
        val tvLogin = view.findViewById<TextView>(R.id.tvSignIn)

        btnRegister.setOnClickListener{
            val name = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirm = etConfirm.text.toString().trim()

            if (name.isNotEmpty() && lastName.isNotEmpty() && age.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirm.isNotEmpty()){
                if (password == confirm){
                    val mainActivity = activity as? MainActivity
                    mainActivity?.navigateToSignInWithData(email, name, lastName, age)

                    Toast.makeText(requireContext(), "Регистрация успешна!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }

        tvLogin.setOnClickListener{
            val mainActivity = activity as? MainActivity
            mainActivity?.navigateToSignIn()
        }

        return view
    }
}