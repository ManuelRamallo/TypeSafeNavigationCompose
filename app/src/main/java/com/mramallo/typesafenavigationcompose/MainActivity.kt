package com.mramallo.typesafenavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mramallo.typesafenavigationcompose.ui.navigation.DetailScreen
import com.mramallo.typesafenavigationcompose.ui.navigation.HomeScreen
import com.mramallo.typesafenavigationcompose.ui.screens.DetailScreen
import com.mramallo.typesafenavigationcompose.ui.screens.HomeScreen
import com.mramallo.typesafenavigationcompose.ui.theme.TypeSafeNavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypeSafeNavigationComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = HomeScreen
                ) {
                    composable<HomeScreen> {
                        HomeScreen(
                            onDetailClick = { name, age ->
                                navController.navigate(DetailScreen(name = name, age = age))
                            }
                        )
                    }
                    composable<DetailScreen> {
                        val args = it.toRoute<DetailScreen>()
                        DetailScreen(
                            name = args.name,
                            age = args.age,
                            onBackClick = {
                                navController.popBackStack(
                                    route = HomeScreen,
                                    inclusive = true
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}