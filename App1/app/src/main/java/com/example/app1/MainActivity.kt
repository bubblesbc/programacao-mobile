package com.example.app1

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var messageField = findViewById<EditText>(R.id.messageField)
        var textView = findViewById<TextView>(R.id.textView)
        var checkbox = findViewById<CheckBox>(R.id.checkbox)

        fun updateText() {
            var name = messageField.text.toString()

            if (checkbox.isChecked) {
                textView.text = UCharacter.toUpperCase(name)
            } else {
                textView.text = name
            }
        }

        messageField.addTextChangedListener {
            updateText()
        }

        checkbox.setOnClickListener {
            updateText()
        }
    }
}