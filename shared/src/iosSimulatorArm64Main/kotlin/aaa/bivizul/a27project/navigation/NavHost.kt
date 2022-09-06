package aaa.bivizul.a27project.navigation

import androidx.compose.runtime.Composable

@Composable
actual fun NavHost(
    navController: NavHostController,
    startDestination: String,
    route: String?,
    builder: NavGraphBuilder.() -> Unit,
) {
}

@Composable
actual fun rememberNavController(): NavHostController {
    TODO("Not yet implemented")
}

actual class NavOptionsBuilder
actual class NavController
actual class NamedNavArgument
actual class Bundle {
    actual fun get(p0: String): Any? {
        TODO("Not yet implemented")
    }
}

actual class NavHostController {
    actual fun popBackStack(): Boolean {
        TODO("Not yet implemented")
    }
}

actual class NavGraphBuilder
actual class NavBackStackEntry {
    actual val arguments: Bundle?
        get() = TODO("Not yet implemented")
}

actual class NavDeepLink

actual fun NavGraphBuilder.composable(
    route: String,
    title: String?,
    leadingButton: @Composable (() -> Unit)?,
    trailingButton: @Composable (() -> Unit)?,
    arguments: List<NamedNavArgument>,
    deepLinks: List<NavDeepLink>,
    content: @Composable (NavBackStackEntry) -> Unit,
) {
}

actual fun NavController.navigate(
    route: String,
    builder: NavOptionsBuilder.() -> Unit,
) {
}