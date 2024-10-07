package com.mramallo.typesafenavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mramallo.typesafenavigationcompose.domain.entity.BreedSize
import com.mramallo.typesafenavigationcompose.domain.entity.Dog
import com.mramallo.typesafenavigationcompose.ui.navigation.CustomNavType
import com.mramallo.typesafenavigationcompose.ui.navigation.DetailRoute
import com.mramallo.typesafenavigationcompose.ui.navigation.DogDetailRoute
import com.mramallo.typesafenavigationcompose.ui.navigation.DogListRoute
import com.mramallo.typesafenavigationcompose.ui.navigation.HomeRoute
import com.mramallo.typesafenavigationcompose.ui.screens.DetailScreen
import com.mramallo.typesafenavigationcompose.ui.screens.DogDetailScreen
import com.mramallo.typesafenavigationcompose.ui.screens.DogListScreen
import com.mramallo.typesafenavigationcompose.ui.screens.HomeScreen
import com.mramallo.typesafenavigationcompose.ui.theme.TypeSafeNavigationComposeTheme
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypeSafeNavigationComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = HomeRoute
                ) {
                    composable<HomeRoute> {
                        HomeScreen(
                            onDetailClick = { name, age ->
                                navController.navigate(DetailRoute(name = name, age = age))
                            },
                            onListClick = {
                                navController.navigate(DogListRoute)
                            }
                        )
                    }
                    composable<DetailRoute> {
                        val args = it.toRoute<DetailRoute>()
                        DetailScreen(
                            name = args.name,
                            age = args.age,
                            onBackClick = {
                                navController.popBackStack(route = HomeRoute, inclusive = false)
                            }
                        )
                    }
                    composable<DogListRoute> {
                        DogListScreen(
                            onBackClick = {
                                navController.popBackStack(route = HomeRoute, inclusive = false)
                            },
                            onDogClick = { dog, breedSize ->
                                navController.navigate(
                                    DogDetailRoute(
                                        dog = dog,
                                        breedSize = breedSize
                                    )
                                )
                            }
                        )
                    }
                    composable<DogDetailRoute>(
                        typeMap = mapOf(
                            typeOf<Dog>() to CustomNavType.dogType,
                            typeOf<BreedSize>() to NavType.EnumType(BreedSize::class.java)
                        )
                    ) {
                        val args = it.toRoute<DogDetailRoute>()
                        DogDetailScreen(
                            dog = args.dog,
                            breedSize = args.breedSize,
                            onBackClick = {
                                navController.popBackStack(route = DogListRoute, inclusive = false)
                            }
                        )
                    }
                }
            }
        }
    }
}