package com.example.application.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.application.R
import com.example.application.fragments.HomeFragment
import com.example.application.fragments.OnboardFragment
import com.example.application.fragments.RegistrFragment
import com.example.application.fragments.SignInFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showStartFragment()
        }
    }

    private fun showStartFragment() {
        val fragment = OnboardFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun navigateToSignIn(){
        val fragment = SignInFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("signin")
            .commit()
    }

    fun navigateToSignUp(){
        val fragment = RegistrFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun navigateToHome() {
        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun navigateToOnboard() {
        val fragment = OnboardFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun navigateToSignInWithData(email: String, name: String, lastName: String, age: String) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        val fragment = SignInFragment()
        val args = Bundle().apply {
            putString("email", email)
            putString("name", name)
            putString("lastName", lastName)
            putString("age", age)
        }
        fragment.arguments = args

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun showOnboardFragment() {
        val fragment = OnboardFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}