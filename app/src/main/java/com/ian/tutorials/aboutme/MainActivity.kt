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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }

    }


    //adding click listener
    private fun addNickname(view: View){

        // initialize views with findViewById referencing
        val editText:EditText = findViewById(R.id.nickname_edit)
        val nicknameTextView:TextView = findViewById(R.id.nickname_text)

        //set the text to the textview
        nicknameTextView.text = editText.text

        //change visibility of the different views
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE


        //hide the keyboard
        //get the input method manager
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)


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