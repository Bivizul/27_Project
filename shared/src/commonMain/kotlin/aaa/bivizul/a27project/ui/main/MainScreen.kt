package aaa.bivizul.a27project.ui.main

import aaa.bivizul.a27project.navigation.Destination
import aaa.bivizul.a27project.navigation.NavController
import aaa.bivizul.a27project.navigation.navigate
import aaa.bivizul.a27project.ui.theme.Typography
import aaa.bivizul.a27project.ui.widget.ButtonLev
import aaa.bivizul.a27project.util.Levconst.NAME_APP
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Surface(
        modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = NAME_APP,
                style = Typography.h3
            )
            ButtonLev(
                modifier = modifier,
                onClick = { navController.navigate(Destination.Leverages.route) },
                text = "Leverages"
            )
        }
    }
}