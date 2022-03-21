package com.example.login.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.login.R
import com.google.android.material.textfield.TextInputLayout


class Firstpage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_firstpage, container, false)
        val login = view.findViewById<Button>(R.id.login_btn)
        val fragmentManager = parentFragmentManager
        val username = view.findViewById<TextInputLayout>(R.id.username_input)
        val password = view.findViewById<TextInputLayout>(R.id.password_input)
        val bundle = Bundle()

        login.setOnClickListener {
            val usernameOne = username.editText?.text.toString().trim()
            val passwordOne = password.editText?.text.toString().trim()
            username.error = null
            password.error = null
            when {
                usernameOne.isEmpty() -> {
                    username.error = "This is an required field"
                }
                usernameOne.length > 15 -> {
                    username.error = "Username is Too long"
                }
                passwordOne.isEmpty() -> {
                    password.error = "This is an required field"
                }
                else -> {
                    bundle.putString("Message", usernameOne)
                    val transaction = fragmentManager.beginTransaction()
                    val fTwo = Basicfrag()
                    fTwo.arguments = bundle
                    transaction.replace(R.id.landing_fragment, fTwo)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        }
        return view
    }
}

