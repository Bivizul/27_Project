package aaa.bivizul.a27project.ui.main

import aaa.bivizul.a27project.model.Leverages
import aaa.bivizul.a27project.navigation.Destination
import aaa.bivizul.a27project.navigation.NavController
import aaa.bivizul.a27project.navigation.navigate
import aaa.bivizul.a27project.ui.theme.A27ProjectTheme
import aaa.bivizul.a27project.ui.theme.Typography
import aaa.bivizul.a27project.ui.widget.BackImage
import aaa.bivizul.a27project.ui.widget.ButtonLev
import aaa.bivizul.a27project.ui.widget.CircularProgress
import aaa.bivizul.a27project.viewmodel.LeveragesViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.aakira.napier.Napier
import io.github.aakira.napier.log

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    println("MainScreen")

    Surface(
        modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Name Project",
                style = Typography.h3
            )
            ButtonLev(
                modifier=modifier,
                onClick = { navController.navigate(Destination.Leverages.route) },
                text = "Leverages"
            )
        }
    }







}