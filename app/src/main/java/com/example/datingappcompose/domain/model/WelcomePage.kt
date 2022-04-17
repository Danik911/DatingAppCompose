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
        description = "Вы запустили приложение по выбору идеального партнера",
        buttonText = "Далее"
    )

    object Second : WelcomePage(
        title = "Пожалуйста...",
        description = "Отнеситесь к этому тесту серьезно. От него будет зависеть выбор вашего партнера.",
        buttonText = "Далее"
    )

    object Third : WelcomePage(
        title = "Внимание!",
        description = "Вы выглядите превосходно!",
        buttonText = "Далее"
    )
    object Forth : WelcomePage(
        title = "Ответьте на 5 вопросов",
        description = "Это даст понять как вы любите проводить свободное время",
        buttonText = "Далее"
    )
    object Fifth : WelcomePage(
        title = "Вы готовы?",
        description = "Встретить свою любовь",
        buttonText = "Поехали!"
    )
}