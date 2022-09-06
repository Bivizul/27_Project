package aaa.bivizul.a27project.navigation

import aaa.bivizul.a27project.ui.leveges.LevegesScreen
import aaa.bivizul.a27project.ui.leverages.LeveragesScreen
import aaa.bivizul.a27project.ui.leveragesdetail.LeveragesDetailScreen
import aaa.bivizul.a27project.ui.main.MainScreen
import aaa.bivizul.a27project.viewmodel.LevegesViewModel
import aaa.bivizul.a27project.viewmodel.LeveragesViewModel
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun LevNavGraph(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = Destination.Leveges.route,
) {
    val context = LocalContext.current
    val activity = LocalContext.current as Activity

    val levegesViewModel = LevegesViewModel()
    val leveragesViewModel = LeveragesViewModel()

    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(route = startDestination) {
            LevegesScreen(
                onClick = { navHostController.navigate(Destination.Main.route) },
                navController = navHostController,
                context = context,
                activity = activity,
                levegesViewModel = levegesViewModel
            )
        }

        composable(route = Destination.Main.route) {
            MainScreen(
                navController = navHostController
            )
            BackHandler() {
                activity.finish()
                System.exit(0)
            }
        }

        composable(route = Destination.Leverages.route) {
            LeveragesScreen(
                navController = navHostController,
                leveragesViewModel = leveragesViewModel
            )
        }

        composable(route = Destination.LeveragesDetail.route + "{${Destination.LeveragesItemId.route}}") { backStaskEntry ->
            val arguments = requireNotNull(backStaskEntry.arguments)
            LeveragesDetailScreen(
                leveragesViewModel = leveragesViewModel,
                itemId = arguments.getString(Destination.LeveragesItemId.route) ?: "1"
            )
        }

    }

}