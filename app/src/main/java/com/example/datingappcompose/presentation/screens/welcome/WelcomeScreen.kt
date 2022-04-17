package com.example.datingappcompose.presentation.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.datingappcompose.R
import com.example.datingappcompose.domain.model.WelcomePage
import com.example.datingappcompose.ui.theme.*
import com.example.datingappcompose.util.Constants.HORIZONTAL_PAGER_COUNT
import com.google.accompanist.pager.*


@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navHostController: NavHostController,
) {
    val pages = listOf(
        WelcomePage.First,
        WelcomePage.Second,
        WelcomePage.Third,
        WelcomePage.Forth,
        WelcomePage.Fifth
    )
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = HORIZONTAL_PAGER_COUNT,
        state = pagerState,
        verticalAlignment = Alignment.Bottom
    ) { position ->
        PagerScreen(welcomePage = pages[position], modifier = Modifier, onClickFinish = {})
    }

    /*   FinishButton(pagerState = pagerState, modifier = Modifier.weight(1f)) {
           navHostController.popBackStack()
           navHostController.navigate(Screen.Home.route)
       }*/
}


@Composable
fun PagerScreen(welcomePage: WelcomePage, modifier: Modifier, onClickFinish: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = WelcomeBackgroundColor),

        ) {
        IconButton(onClick = {}) {
            Icon(
                modifier = Modifier.padding(start = 6.dp, top = 20.dp),
                tint = AccentColor,
                painter = painterResource(id = R.drawable.ic_icon_arrow_left),
                contentDescription = "Back icon"
            )
        }
        Surface(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 60.dp, bottom = 70.dp),
            shape = RoundedCornerShape(Shapes.pagerShape),


            ) {
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
                        .fillMaxWidth()
                        .padding(top = 70.dp, bottom = 46.dp),
                    text = welcomePage.title,
                    color = Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .width(98.dp)
                        .background(StrokeColor)
                        .height(1.dp)
                ) {

                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp, start = 42.dp, end = 42.dp),
                    text = welcomePage.description,
                    color = BodyColor,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

            }

        }
        FinishButton(modifier = Modifier, onClickFinish = onClickFinish, welcomePage = welcomePage)
    }


}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(onClickFinish: () -> Unit, modifier: Modifier, welcomePage: WelcomePage) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 60.dp, end = 60.dp)


    ) {

        Button(
            modifier = modifier
                .size(width = 300.dp, height = 60.dp),
            onClick = onClickFinish,
            colors = ButtonDefaults.buttonColors(AccentColor),
            shape = RoundedCornerShape(Shapes.buttonShape),
        ) {
            Text(text = welcomePage.buttonText, color = White)
        }
    }

}


@Composable
@Preview(showBackground = true)
fun WelcomeScreenPreview() {
    Column(modifier = Modifier) {
        PagerScreen(welcomePage = WelcomePage.First, modifier = Modifier, onClickFinish = {})
    }

}