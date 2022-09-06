package aaa.bivizul.a27project.ui.leveragesdetail

import aaa.bivizul.a27project.ui.widget.CircularProgress
import aaa.bivizul.a27project.viewmodel.LeveragesViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun LeveragesDetailScreen(
    modifier: Modifier = Modifier,
    leveragesViewModel: LeveragesViewModel,
    itemId: String
) {
    println("LeveragesDetailScreen")

    LaunchedEffect(Unit) {
        leveragesViewModel.getLeverages()
    }

    val leverages by leveragesViewModel.leverages.collectAsState(null)

    if (leverages != null) {
        leverages?.let {
            println("LeveragesDetailScreen itemId : $itemId")
            val item = it.leverage[itemId.toInt() - 1]
            Column {
                Text(item.title)
                Text(item.description)
            }
        }
    } else {
        CircularProgress(modifier)
    }
}