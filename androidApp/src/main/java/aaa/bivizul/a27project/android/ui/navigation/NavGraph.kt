package aaa.bivizul.a27project.android.ui.navigation

import aaa.bivizul.a27project.ui.leveges.LevegesScreen
import aaa.bivizul.a27project.ui.main.MainScreen
import aaa.bivizul.a27project.util.*
import aaa.bivizul.a27project.viewmodel.LevegesViewModel
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Leveges

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Leveges : Screen("leveges")
}

@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Leveges.route,
) {
    val context = LocalContext.current
    val activity = LocalContext.current as Activity
//    val levegesViewModel = LevegesViewModel()
//    LaunchedEffect(Unit){
//        try {
//            levegesViewModel.getLeveges(
//                Leveges(
//                    getLevegesmm(),
//                    getLevegessim(context),
//                    getLevegesid(context),
//                    getLevegesl(),
//                    getLevegest()
//                )
//            )
//        } catch (e: Exception) {
//            getLevegedia(context,activity)
//        }
//    }

    NavHost(navController = navHostController, startDestination = startDestination){
        composable(route = startDestination){
//            val a = navHostController.navigate(Screen.Main.route)
            LevegesScreen(
                onClick = { navHostController.navigate(Screen.Main.route) },
//                navigateScreen = navHostController.navigate(Screen.Main.route),
                context = context,
                activity = activity
            )
        }

        composable(route = Screen.Main.route){
            MainScreen()
            BackHandler() {
                activity.finish()
                System.exit(0)
            }
        }

    }
    
}