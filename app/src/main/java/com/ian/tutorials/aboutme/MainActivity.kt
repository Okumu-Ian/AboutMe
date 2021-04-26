package com.ian.tutorials.aboutme

import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.ian.tutorials.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //create a Binding Object to the main activity
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //replace set content view function with one from databinding util
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        //replace all findViewById calls
        binding.doneButton.setOnClickListener {
            addNickname()
        }

        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }

    }


    //adding click listener
    private fun addNickname(){

        // initialize views with findViewById referencing
        /*val editText:EditText = findViewById(R.id.nickname_edit)
        val nicknameTextView:TextView = findViewById(R.id.nickname_text)*/
        //Delete all definitions using the findViewById calls

        //set the text to the textview
        binding.nicknameText.text = binding.nicknameEdit.text.toString()

        //change visibility of the different views
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        //Alternative Kotlin function
        /*binding.apply {
            nicknameText.text = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }*/


        //hide the keyboard
        //get the input method manager
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)


    }


    //update nickname function
    private fun updateNickname(view:View){

        //reference IDs
        val editText:EditText = findViewById(R.id.nickname_edit)
        val doneButton:Button = findViewById(R.id.done_button)

        //set visibilities
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE


        //set the focus to the EditText  and show keyboard
        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText,0)


    }

}