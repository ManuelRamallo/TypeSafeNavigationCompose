package com.mramallo.typesafenavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mramallo.typesafenavigationcompose.ui.navigation.Detail
import com.mramallo.typesafenavigationcompose.ui.navigation.Home
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
                    startDestination = Home
                ) {
                    composable<Home> {
                        HomeScreen(
                            onDetailClick = {
                                navController.navigate(Detail)
                            }
                        )
                    }
                    composable<Detail> {
                        val args = it.toRoute<Detail>()
                        DetailScreen(
                            name = args.name,
                            age = args.age,
                            onBack = { navController.popBackStack(route = Home, inclusive = true) }
                        )
                        /*Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(text = "${args.name}, ${args.age} years old")
                        }*/
                    }
                }
            }
        }
    }
}