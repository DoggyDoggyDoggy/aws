package denys.diomaxius.aws.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import denys.diomaxius.aws.ui.screen.Login.LoginScreen
import denys.diomaxius.aws.ui.screen.home.HomeScreen


@Composable
fun AppNavigation(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                navHostController = navHostController
            )
        }

        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}