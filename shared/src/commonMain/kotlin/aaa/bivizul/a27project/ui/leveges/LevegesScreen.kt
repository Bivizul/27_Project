package aaa.bivizul.a27project.ui.leveges

import aaa.bivizul.a27project.navigation.Destination
import aaa.bivizul.a27project.navigation.NavController
import aaa.bivizul.a27project.navigation.navigate
import aaa.bivizul.a27project.ui.widget.CircularProgress
import aaa.bivizul.a27project.util.*
import aaa.bivizul.a27project.viewmodel.LevegesViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Leveges
import io.github.aakira.napier.Napier
import io.github.aakira.napier.log
import kotlinx.coroutines.delay

@Composable
fun LevegesScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    navController: NavController,
    context: Any,
    activity: Any,
    levegesViewModel: LevegesViewModel,
) {

    Napier.d(tag = "qwer", message = "LevegesScreen")
    log(tag = "qwer") { "LevegesScreen log" }

//    val context = context
//    val activity = activity
//    val levegesViewModel = LevegesViewModel()
//    val levegesRepository = LevegesRepository()

    LaunchedEffect(Unit) {
        try {
            levegesViewModel.getLeveges(
                Leveges(
                    getLevegesmm(),
                    getLevegessim(context),
                    getLevegesid(context),
                    getLevegesl(),
                    getLevegest()
                )
            )
        } catch (e: Exception) {
            getLevegedia(context, activity)
        }
    }

    val levegesres by levegesViewModel.levegesres.collectAsState(null)
    println("levegesres : $levegesres")

    if (levegesres != null){
        levegesres?.levegesres?.let {
            if (it == "no") {
                LaunchedEffect(Unit) {
                    delay(1000)
                    navController.navigate(Destination.Main.route)
                }
            } else if (it == "nopush") {
                LaunchedEffect(Unit) {
                    delay(1000)
                    navController.navigate(Destination.Main.route)
                }
            } else {
                println("levegesres ELSE")
                LaunchedEffect(Unit) {
                    delay(1000)
                    navController.navigate(Destination.Main.route)
                }
            }
        }
    } else{
        CircularProgress()
    }
}