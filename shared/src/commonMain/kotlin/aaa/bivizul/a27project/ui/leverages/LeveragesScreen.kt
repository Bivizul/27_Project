package aaa.bivizul.a27project.ui.leverages

import aaa.bivizul.a27project.navigation.Destination
import aaa.bivizul.a27project.navigation.NavController
import aaa.bivizul.a27project.navigation.navigate
import aaa.bivizul.a27project.ui.widget.CircularProgress
import aaa.bivizul.a27project.viewmodel.LeveragesViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun LeveragesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    leveragesViewModel: LeveragesViewModel
) {
    println("LeveragesScreen")

//    val leveragesViewModel = LeveragesViewModel()
    LaunchedEffect(Unit){
        leveragesViewModel.getLeverages()
    }

    val leverages by leveragesViewModel.leverages.collectAsState(null)

    if (leverages != null){
        leverages?.let { leveragesItem ->
            Column(
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = leveragesItem.titleLeverages)
                Text(text = leveragesItem.intro)
                LazyRow {
                    items(leveragesItem.leverage){item->
                        Button(
                            onClick = {
                                navController.navigate(Destination.LeveragesDetail.route +"${item.id}")
                            }
                        ) {
                            Text(text = item.id.toString())
                        }
                    }
                }

            }
        }

    }else{
        CircularProgress(modifier)
    }

}
