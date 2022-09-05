package aaa.bivizul.a27project.ui.leveges

import aaa.bivizul.a27project.util.*
import aaa.bivizul.a27project.viewmodel.LevegesViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Leveges

@Composable
fun LevegesScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
//    navigateScreen: Unit,
    context: Any,
    activity: Any,
) {
    val context = context
    val activity = activity
    val levegesViewModel = LevegesViewModel()
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

    levegesres?.levegesres?.let {
        if (it == "no") {
            println("levegesres NO")
//            navigateScreen
        } else if (it == "nopush") {
            println("levegesres NOPUSH")
//            OneSignal.disablePush(true)
//            navigateScreen
        } else {
            println("levegesres ELSE")
//            val spliskantent = Intent(activity, SpliskaActivity::class.java)
//            spliskantent.putExtra(KEY_SPLISKA, it)
//            activity.startActivity(spliskantent)
//            navigateScreen
        }
    }

    Box(modifier) {
        Column {
            Text(text = "LevegesScreen")
            Button(
                onClick = onClick
            ) {
                Text("Main")
            }
            CircularProgressIndicator()
        }
    }
}