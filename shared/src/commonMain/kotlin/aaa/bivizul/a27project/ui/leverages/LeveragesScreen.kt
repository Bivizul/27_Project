package aaa.bivizul.a27project.ui.leverages

import aaa.bivizul.a27project.navigation.Destination
import aaa.bivizul.a27project.navigation.NavController
import aaa.bivizul.a27project.navigation.navigate
import aaa.bivizul.a27project.ui.theme.Typography
import aaa.bivizul.a27project.ui.widget.ButtonLev
import aaa.bivizul.a27project.ui.widget.CircularProgress
import aaa.bivizul.a27project.util.getLevegedia
import aaa.bivizul.a27project.viewmodel.LeveragesViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LeveragesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    leveragesViewModel: LeveragesViewModel,
    contextAny: Any,
    activityAny: Any,
) {

    LaunchedEffect(Unit) {
        try {
            leveragesViewModel.getLeverages()
        } catch (e: Exception) {
            getLevegedia(contextAny, activityAny)
        }
    }

    val leverages by leveragesViewModel.leverages.collectAsState(null)
    val scrollState = rememberScrollState()

    if (leverages != null) {
        leverages?.let { leveragesItem ->
            Surface(
                color = MaterialTheme.colors.background
            ) {
                Column(
                    modifier = modifier.fillMaxSize().padding(8.dp).verticalScroll(scrollState),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = leveragesItem.titleLeverages,
                        style = Typography.h4,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = leveragesItem.intro,
                        style = Typography.body1
                    )
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(leveragesItem.leverage) { item ->
                            ButtonLev(
                                modifier = modifier,
                                onClick = {
                                    navController.navigate(Destination.LeveragesDetail.route + "${item.id}")
                                },
                                text = item.id.toString()
                            )
                        }
                    }
                }
            }
        }
    } else {
        CircularProgress(modifier)
    }
}
