package com.example.alculation

import androidx.annotation.IdRes

enum class Choise(@IdRes val resourceId: Int, val russianName: String) {
    ROCK(R.id.button_rock, "Камень"),
    SCISSORS(R.id.button_scissors, "Ножницы"),
    PAPER(R.id.button_paper, "Бумага")
}