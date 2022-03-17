package com.example.login.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.login.R


class Firstpage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_firstpage, container, false)
        val login = view.findViewById<Button>(R.id.login_btn)
        val fragmentManager = parentFragmentManager
        val username = view.findViewById<EditText>(R.id.user_input)
        val password = view.findViewById<EditText>(R.id.pass_input)
        val bundle = Bundle()

        login.setOnClickListener {
            val usernameOne = username.text.toString()
            val passwordOne = password.text.toString()
            if (usernameOne.isEmpty() || passwordOne.isEmpty()) {
                Toast.makeText(activity, "Fill the required fields", Toast.LENGTH_LONG).show()
            } else {
                bundle.putString("Message", usernameOne)
                val transaction = fragmentManager.beginTransaction()
                val fTwo = Basicfrag()
                fTwo.arguments = bundle
                transaction.replace(R.id.landing_fragment, fTwo)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
        return view
    }
}
