package com.example.datingappcompose.domain.model

import androidx.annotation.DrawableRes
import com.example.datingappcompose.R

sealed class WelcomePage(

    val title: String,
    val description: String,
    val buttonText: String
) {
    object First : WelcomePage(
        title = "Приветствуем вас!",
        description = "Вы запустили приложение по выбору идеальногопартнера",
        buttonText = "Далее"
    )

    object Second : WelcomePage(
        title = "Explore",
        description = "Find your favorite heroes and learn some of the things that you didn't know about.",
        buttonText = "Далее"
    )

    object Third : WelcomePage(
        title = "Power",
        description = "Check out your hero's power and  see how much are they strong comparing to others.",
        buttonText = "Далее"
    )
}