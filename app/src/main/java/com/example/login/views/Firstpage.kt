package com.example.login.views


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.login.R
import com.example.login.databinding.ActivityFirstpageBinding
import com.example.login.mvvm.LoginAuthViewModel
import com.example.login.mvvm.LoginAuthViewModel.Companion.LOGIN_SUCCESS
import com.example.login.mvvm.LoginAuthViewModel.Companion.NONE
import com.example.login.mvvm.LoginAuthViewModel.Companion.NORMAL
import com.example.login.mvvm.LoginAuthViewModel.Companion.PASSWORD_EMPTY
import com.example.login.mvvm.LoginAuthViewModel.Companion.TOO_LONG
import com.example.login.mvvm.LoginAuthViewModel.Companion.USERNAME_EMPTY

class Firstpage : Fragment() {

   private var loginViewModel : LoginAuthViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding: ActivityFirstpageBinding =
            DataBindingUtil.inflate(inflater, R.layout.activity_firstpage, container, false)
         loginViewModel = ViewModelProvider(this).get(LoginAuthViewModel::class.java)
        binding.viewmodel = loginViewModel

        val fragmentManager = parentFragmentManager

        val view = inflater.inflate(R.layout.activity_firstpage, container, false)

        val bundle = Bundle()
        val signup = view.findViewById<Button>(R.id.signup_btn)

        loginViewModel?.uiEvent?.observe(viewLifecycleOwner) { event ->
            when (event) {
                USERNAME_EMPTY -> {
                    Toast.makeText(context, "Username is empty", Toast.LENGTH_SHORT).show()
                    loginViewModel?.uiEvent?.value = NONE
                }
                PASSWORD_EMPTY -> {
                    Toast.makeText(context, "Password is empty", Toast.LENGTH_SHORT).show()
                    loginViewModel?.uiEvent?.value = NONE
                }
                LOGIN_SUCCESS -> {
                    Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
                    loginViewModel?.uiEvent?.value = NONE

               //     bundle.putString("Message", usernameOne)


                }

            }
            val transaction = fragmentManager.beginTransaction()
            val fTwo = Basicfrag()
            fTwo.arguments = bundle
            transaction.replace(R.id.landing_fragment, fTwo)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.etUsername.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                onUsernameWatcher(p0.toString())
            }
        })

        loginViewModel?.uiEventUsernameLength?.observe(viewLifecycleOwner) {
            when(it) {
                TOO_LONG -> {
                    binding.usernameInput.error = "Length is too long"
                    loginViewModel?.uiEventUsernameLength?.value = NONE
                }
                NORMAL -> {
                    binding.usernameInput.isErrorEnabled = false
                    loginViewModel?.uiEventUsernameLength?.value = NONE
                }
            }
        }

        signup.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.add(R.id.landing_fragment, PopupMenu())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return binding.root
    }

    fun onUsernameWatcher(username:String)
    {
        if(username.trim().length > 15)
        {
            loginViewModel?.uiEventUsernameLength?.value = TOO_LONG
        }
        else
        {
            loginViewModel?.uiEventUsernameLength?.value = NORMAL
        }

    }
}

