package com.example.bingo

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoadingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loadingscreen)

        val btnCreate = findViewById<Button>(R.id.btnCreate)
        val etSize = findViewById<EditText>(R.id.etSize)
        val tvIncorrect = findViewById<TextView>(R.id.tvIncorrect)

        var input: String

        btnCreate.setOnClickListener {
            input = etSize.text.toString()
            val inputConvert = input.toInt()

            if ((inputConvert % 5) == 0) {
                tvIncorrect.text = "$inputConvert works"
                Thread.sleep(1000)

                if (inputConvert == 5) {
                    val intent = (Intent(this, SmallCard::class.java))
                    val bundle = Bundle()
                    intent.putExtra("lengthOfCard", inputConvert)
                    intent.putExtras(bundle)
                    startActivity(intent)
                } else if (inputConvert == 10){
                    val intent = (Intent(this, MediumCard::class.java))
                    val bundle = Bundle()
                    intent.putExtra("lengthOfCard", inputConvert)
                    intent.putExtras(bundle)
                    startActivity(intent)
                } else if (inputConvert == 15) {
                    val intent = (Intent(this, LargeCard::class.java))
                    val bundle = Bundle()
                    intent.putExtra("lengthOfCard", inputConvert)
                    intent.putExtras(bundle)
                    startActivity(intent)
                } else {
                    tvIncorrect.text = "The value $inputConvert is not a Supported YET!"
                }

            } else {
                tvIncorrect.text = "The value $inputConvert is not a multiple of 5"
            }

        }


        etSize.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                tvIncorrect.text = " "

            }
        })

    }
}