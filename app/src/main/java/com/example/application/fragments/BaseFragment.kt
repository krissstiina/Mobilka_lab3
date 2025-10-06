package com.example.application.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    protected val fragmentTag: String
        get() = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(fragmentTag, "onCreate - фрагмент создается")
    }

    override fun onStart() {
        super.onStart()
        Log.d(fragmentTag, "onStart - фрагмент становится видимым")
    }

    override fun onResume() {
        super.onResume()
        Log.d(fragmentTag, "onResume - фрагмент активен")
    }

    override fun onPause() {
        super.onPause()
        Log.d(fragmentTag, "onPause - фрагмент теряет фокус")
    }

    override fun onStop() {
        super.onStop()
        Log.d(fragmentTag, "onStop - фрагмент не виден")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(fragmentTag, "onDestroy - фрагмент уничтожается")
    }
}