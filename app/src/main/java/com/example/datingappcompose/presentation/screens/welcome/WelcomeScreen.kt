package com.example.datingappcompose.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.datingappcompose.R
import com.example.datingappcompose.domain.model.WelcomePage
import com.example.datingappcompose.navigation.Screen
import com.example.datingappcompose.ui.theme.AccentColor
import com.example.datingappcompose.ui.theme.HORIZONTAL_PAGER_COUNT
import com.example.datingappcompose.ui.theme.StrokeColor
import com.example.datingappcompose.ui.theme.WelcomeBackgroundColor
import com.google.accompanist.pager.*


@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navHostController: NavHostController,
) {
    val pages = listOf(
        WelcomePage.First,
        WelcomePage.Second,
        WelcomePage.Third
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WelcomeBackgroundColor)
            .padding(start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = HORIZONTAL_PAGER_COUNT,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(WelcomePage = pages[position], modifier = Modifier)
        }

        /*   FinishButton(pagerState = pagerState, modifier = Modifier.weight(1f)) {
               navHostController.popBackStack()
               navHostController.navigate(Screen.Home.route)
           }*/
    }


}

@Composable
fun PagerScreen(WelcomePage: WelcomePage, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = WelcomePage.title,
            //color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(StrokeColor)
                .height(1.dp)
        ) {

        }
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = WelcomePage.description,
            //color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        FinishButton() {

        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(onClickFinish: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
        //.padding(horizontal = PADDING_EXTRA_LARGE)
    ) {

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onClickFinish,
            colors = ButtonDefaults.buttonColors(AccentColor)
        ) {
            Text(text = "Finish", color = White)
        }
    }

}


@Composable
@Preview(showBackground = true)
fun WelcomeScreenPreview() {
    Column(modifier = Modifier) {
        PagerScreen(WelcomePage = WelcomePage.First, modifier = Modifier)
    }

}