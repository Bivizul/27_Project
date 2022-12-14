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
import kotlinx.coroutines.delay

@Composable
fun LevegesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    context: Any,
    activity: Any,
    levegesViewModel: LevegesViewModel,
) {

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

    if (levegesres != null) {
        levegesres?.levegesres?.let {
            if (it == Levares.NO.lvs) {
                LaunchedEffect(Unit) {
                    delay(1000)
                    navController.navigate(Destination.Main.route)
                }
            } else if (it == Levares.NP.lvs) {
                LaunchedEffect(Unit) {
                    delay(1000)
                    levSignalOff()
                    navController.navigate(Destination.Main.route)
                }
            } else {
                LaunchedEffect(Unit) {
                    delay(1000)
                    LevBrow(context, it)
                    levscreenExit(activity)
                }
            }
        }
    } else {
        CircularProgress()
    }
}