package com.example.app4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var messageField = findViewById<EditText>(R.id.messageField)
        var total = findViewById<TextView>(R.id.total)
        var radiogroup = findViewById<RadioGroup>(R.id.radiogroup)

        fun update(){
            var text = messageField.text.toString()
            var numb = text.toDouble()

            var selected = radiogroup.checkedRadioButtonId

            var percentage = 0

            if (selected == R.id.rb1) percentage = 35

            if (selected == R.id.rb2) percentage = 40

            if (selected == R.id.rb3) percentage = 45

            numb = numb + ((numb * percentage) / 100)

            total.text = numb.toString()
        }
        messageField.addTextChangedListener {
            update()
        }

        radiogroup.setOnCheckedChangeListener { group, checkedId ->
            update()
        }
    }
}