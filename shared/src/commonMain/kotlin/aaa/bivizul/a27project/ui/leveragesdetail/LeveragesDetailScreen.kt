package aaa.bivizul.a27project.ui.leveragesdetail

import aaa.bivizul.a27project.ui.theme.Typography
import aaa.bivizul.a27project.ui.widget.CircularProgress
import aaa.bivizul.a27project.viewmodel.LeveragesViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LeveragesDetailScreen(
    modifier: Modifier = Modifier,
    leveragesViewModel: LeveragesViewModel,
    itemId: String,
) {
    println("LeveragesDetailScreen")

    LaunchedEffect(Unit) {
        leveragesViewModel.getLeverages()
    }

    val leverages by leveragesViewModel.leverages.collectAsState(null)
    val scrollState = rememberScrollState()

    if (leverages != null) {
        leverages?.let {
            println("LeveragesDetailScreen itemId : $itemId")
            val item = it.leverage[itemId.toInt() - 1]
            Surface(
                modifier = modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Column(
                    modifier = modifier
                        .padding(8.dp)
                        .verticalScroll(scrollState)
                ) {
                    Text(
                        text = item.title,
                        modifier = modifier.padding(bottom = 8.dp),
                        style = Typography.h5
                    )
                    Text(
                        text = item.description,
                        style = Typography.body1
                    )
                }
            }
        }
    } else {
        CircularProgress(modifier)
    }
}