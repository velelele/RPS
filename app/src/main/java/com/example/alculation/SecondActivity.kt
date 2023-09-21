package com.example.alculation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle = intent.extras
        val choiseOrdinal = bundle?.getInt(Choise::class.java.simpleName)
        val userChoice = choiseOrdinal?.let { Choise.values()[it] }

        val computerChoice = Choise.values()[Random.nextInt(Choise.values().size)]
        val result = determineWinner(userChoice, computerChoice)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val userChoiceTextView = findViewById<TextView>(R.id.userChoiceTextView)
        val computerChoiceTextView = findViewById<TextView>(R.id.computerChoiceTextView)

        userChoiceTextView.text = "Ваш выбор: ${userChoice?.russianName}"
        computerChoiceTextView.text = "Компьютер выбрал: ${computerChoice.russianName}"
        resultTextView.text = result


        val playAgainButton = findViewById<Button>(R.id.playAgainButton)
        playAgainButton.setOnClickListener {
            finish()
        }
    }

    private fun determineWinner(userChoice: Choise?, computerChoice: Choise): String {
        return when {
            userChoice == computerChoice -> "Ничья!"
            userChoice == Choise.ROCK && computerChoice == Choise.SCISSORS ||
                    userChoice == Choise.SCISSORS && computerChoice == Choise.PAPER ||
                    userChoice == Choise.PAPER && computerChoice == Choise.ROCK -> "Вы выиграли"
            else -> "Вы проиграли"
        }
    }
}