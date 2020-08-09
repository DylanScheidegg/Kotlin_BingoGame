package com.example.bingo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SmallCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.smallcard)

        val btnReDraw = findViewById<Button>(R.id.btnReDraw)
        val btnRandom = findViewById<Button>(R.id.btnRandom)

        var cardSize: Int
        val i = intent
        try {
            val transLenght = i.getIntExtra("lengthOfCard", 5)
            cardSize = transLenght
        } catch (e: Exception) {
            cardSize = 5
        }

        val pickedArr: ArrayList<Int> = ArrayList()

        val tvBArr = arrayOf(
            R.id.tvB1, R.id.tvB2, R.id.tvB3, R.id.tvB4, R.id.tvB5
        )
        val tvIArr = arrayOf(
            R.id.tvI1, R.id.tvI2, R.id.tvI3, R.id.tvI4, R.id.tvI5
        )
        val tvNArr = arrayOf(
            R.id.tvN1, R.id.tvN2, R.id.tvN4, R.id.tvN5
        )
        val tvGArr = arrayOf(
            R.id.tvG1, R.id.tvG2, R.id.tvG3, R.id.tvG4, R.id.tvG5
        )
        val tvOArr = arrayOf(
            R.id.tvO1, R.id.tvO2, R.id.tvO3, R.id.tvO4, R.id.tvO5
        )

        val boardArray = arrayOf(tvBArr, tvIArr, tvNArr, tvGArr, tvOArr)

        btnReDraw.setOnClickListener {
            val listNums: MutableList<Int> = mutableListOf()
            for (x in 1 until cardSize * 5) {
                listNums.add(x)
            }

            var listCount = 1
            for (ln in listNums) {
                listCount += 1
            }

            val checkArr: ArrayList<Int> = ArrayList()
            for (x in boardArray) {
                var count = 0
                for (y in x) {
                    val tv = findViewById<TextView>(x[count])
                    var check = 0
                    while (check < 1) {
                        val randNum = (1 until listCount).random()

                        if (!checkArr.contains(randNum)) {
                            tv.text = (randNum).toString()
                            tv.setBackgroundColor(Color.TRANSPARENT)

                            count += 1
                            checkArr.add(randNum)
                            check += 1
                            //listNums.removeAt(randNum - 1)
                        } else {
                            println("Bad Number")
                        }
                    }
                }
            }

            if (pickedArr.isNotEmpty()) {
                pickedArr.clear()
            }

        }

        btnRandom.setOnClickListener {
            var x = 0
            while (x < 1) {
                val randGroup = (boardArray.indices).random()
                val randSection = (boardArray[randGroup]).random()

                if (!pickedArr.contains(randSection)) {
                    val tv = findViewById<TextView>(randSection)
                    tv.setBackgroundColor(Color.RED)
                    pickedArr.add(randSection)
                    x += 1
                } else {
                    println("Did not work")
                }
            }

        }

    }
}