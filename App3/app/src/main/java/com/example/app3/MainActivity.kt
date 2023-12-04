package com.example.app3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var messageField = findViewById<EditText>(R.id.messageField)
        var total = findViewById<TextView>(R.id.total)

        messageField.addTextChangedListener {
            var text = messageField.text.toString()
            var numb = text.toDouble()
            numb = numb + ((numb * 92) / 100)
            total.text = numb.toString()
        }
    }
}