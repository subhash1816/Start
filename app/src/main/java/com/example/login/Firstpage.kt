package com.example.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment


class Firstpage : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_firstpage, container, false)
        val login=view.findViewById<Button>(R.id.Login)

        val fmanager=parentFragmentManager
        val user=view.findViewById<EditText>(R.id.userinput)
        val pass=view.findViewById<EditText>(R.id.Passinput)

       val bundle=Bundle()

            login.setOnClickListener {
                val username=user.text.toString()
                val password=pass.text.toString()
                       if(username.isEmpty() || password.isEmpty())
                       {
                           Toast.makeText(activity,"Fill the required fields",Toast.LENGTH_LONG).show()
                       }
                else {
                           bundle.putString("Message", username)
                           val transaction = fmanager.beginTransaction()

                           val fTwo = Basicfrag()
                           fTwo.arguments=bundle


                           transaction.replace(R.id.F1, fTwo)
                           transaction.addToBackStack(null)
                           transaction.commit()
                       }

            }



        return view
    }



    }
